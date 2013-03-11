USE TheMovie
GO

CREATE PROCEDURE createTicket
	@roundID int = 0,
	@seat varchar(1000)
AS
BEGIN
	DECLARE @v_row int,
			@v_col int,
			@r_seat varchar(50),
			@r_ticket varchar(1000),
			@r_index int,
			@c_index int;
	SET @v_row = 64;
	SET @v_col = 0;
	SET @r_index = 0;
	SET @c_index = 0;
	DECLARE @CIndex smallint
	WHILE (@seat<>'')
	BEGIN
		SET @r_index += 1;
		SET @CIndex=CHARINDEX(',',@seat);
		IF @CIndex=0 SET @CIndex=LEN(@seat)+1;
		--透過substring函數取得第一個字串，並設定變數r_seat為此字串
		SET @r_seat = SUBSTRING(@seat,1,@CIndex-1);
		PRINT (@r_seat);
		DECLARE @r_check varchar(50),
				@r_count int;
		SET @r_ticket = '';
		SET @r_count = 0;
		SET @r_check = @r_seat;
		--以迴圈把@r_check每個字元轉數字後加總
		--WHILE (@r_check<>'')
		--BEGIN
		--	SET @r_count += CONVERT(int,SUBSTRING(@r_check,1,1));
		--	SET @r_check = SUBSTRING(@r_check,2,LEN(@r_check)-1);
		--END
		--PRINT @r_count;
		
		IF (CONVERT(decimal, @r_seat)>0)
		BEGIN
			SET @v_row += 1;
			WHILE (@r_seat<>'')
			BEGIN
				SET @c_index += 1;
				IF (CONVERT(int,SUBSTRING(@r_seat,1,1))>0)
				BEGIN
					SET @v_col +=1;
					SET @r_ticket += CHAR(@v_row) + CONVERT(varchar,@v_col) + ' ';
					INSERT INTO ticket (roundsID,seatRow,seatColumn,seatName) values(@roundID,@r_index,@c_index,(CHAR(@v_row) + CONVERT(varchar,@v_col)));
				END
				SET @r_seat = SUBSTRING(@r_seat,2,LEN(@r_seat)-1);
			END
			SET @c_index = 0;
			PRINT @r_ticket;
		END
		SET @r_ticket = '';
		SET @v_col = 0;
		SET @r_count = 0;
		IF @CIndex=LEN(@seat)+1 BREAK;
		SET @seat=SUBSTRING(@seat,@CIndex+1,LEN(@seat)-@CIndex);
	END
END;
GO

EXEC createTicket 1, '11101111110111,11101111110111,11101111110111,11101111110111,11101111110111,00000000000000,11101111110111';
GO

EXEC createTicket 2, '11101111110111,11101111110111,11101111110111,11101111110111,11101111110111,00000000000000,11101111110111';
GO

EXEC createTicket 3, '11101111110111,11101111110111,11101111110111,11101111110111,11101111110111,00000000000000,11101111110111';
GO