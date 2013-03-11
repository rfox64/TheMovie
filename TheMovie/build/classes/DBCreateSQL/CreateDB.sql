
Use TheMovie;
GO

DROP TABLE activity
DROP TABLE ticket
DROP TABLE tickettype
DROP TABLE sales
DROP TABLE rounds
DROP TABLE roompic
DROP TABLE room
DROP TABLE theaterpic
DROP TABLE theater
DROP TABLE MoviePIC
DROP TABLE Movie
DROP TABLE member
DROP TABLE region
DROP TABLE city
DROP TABLE profession
DROP TABLE education

--Create member
CREATE TABLE [dbo].[member](
[mbID] [int] PRIMARY KEY IDENTITY(001,1),
[firstName][varchar](10) not null,
[lastName][varchar](10) null,
[cityID] [int] null,
[regionID] [int] null, 
[address][varchar](max) null,
[mobile][varchar](10) null,
[birthday][date] null,
[gender][int] null,
[proID][int] null,
[eduID][int] null,
[email][varchar](64) null,
[password][varchar](20) null,
[activation][int] null, 
[inactivationD][date] null)
--end create member


CREATE TABLE [dbo].[city](
	[cityID] [int] NOT NULL,
	[cityname] [varchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[cityID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[region]    Script Date: 03/01/2013 13:52:52 ******/

CREATE TABLE [dbo].[region](
	[cityID] [int] NULL,
	[regionID] [int] NOT NULL,
	[regionname] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[regionID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[city]    Script Date: 03/01/2013 13:52:52 ******/

--Create profession
create table [dbo].[profession](
[proID] [int] PRIMARY KEY,
[proName] [varchar](8))
--end create profession
--Create education
create table [dbo].[education](
[eduID] [int] PRIMARY KEY,
[eduName] [varchar])
--end create education

/****** Object:  Table [dbo].[Movie]    Script Date: 02/28/2013 20:47:52 ******/

CREATE TABLE [dbo].[Movie](
	[mvID] [int] IDENTITY(1,1) NOT NULL,
	[mvNameC] [varchar](max) NOT NULL,
	[mvNameE] [varchar](max) NOT NULL,
	[mvStartDate] [date] NOT NULL,
	[mvEndDate] [date] NOT NULL,
	[mvDirector] [varchar](50) NULL,
	[mvCast] [varchar](max) NULL,
	[mvCom] [varchar](max) NULL,
	[mvURL] [varchar](max) NULL,
	[mvStory] [varchar](max) NULL,
	[mvRank] [int] NULL,
	[mvPreview] [varchar](max) NULL,
	[mvLevelID] [int] NULL,
	[mvTypeID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[mvID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Default [DF__Movie__mvRank__40F9A68C]    Script Date: 02/28/2013 20:47:52 ******/
ALTER TABLE [dbo].[Movie] ADD  DEFAULT ((1)) FOR [mvRank]
GO
/****** Object:  Default [DF__Movie__mvLevelID__41EDCAC5]    Script Date: 02/28/2013 20:47:52 ******/
ALTER TABLE [dbo].[Movie] ADD  DEFAULT ((0)) FOR [mvLevelID]
GO

/****** Object:  Table [dbo].[MoviePIC]    Script Date: 03/01/2013 10:58:40 ******/

CREATE TABLE [dbo].[MoviePIC](
	[mvPicID] [int] IDENTITY(1,1) NOT NULL,
	[mvID] [int] NULL,
	[mvPic] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[mvPicID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  ForeignKey [fk_mvID]    Script Date: 03/01/2013 10:58:40 ******/
ALTER TABLE [dbo].[MoviePIC]  WITH CHECK ADD  CONSTRAINT [fk_mvID] FOREIGN KEY([mvID])
REFERENCES [dbo].[Movie] ([mvID])
GO
ALTER TABLE [dbo].[MoviePIC] CHECK CONSTRAINT [fk_mvID]
GO

CREATE TABLE [dbo].[theater](
[theaID][int]PRIMARY KEY IDENTITY(001,1) not null,
[theaName][varchar](20) not null,
[cityID][int] not null,
[regionID][int] not null,
[address][varchar](max) not null,
[phone][varchar](15) not null,
[summary][varchar](max) not null,
[traffic] [varchar](max)
)

GO
CREATE TABLE [dbo].[theaterpic](
[theaPicID][int]PRIMARY KEY not null,
[theaID][int] FOREIGN KEY (theaID) REFERENCES theater(theaID),
[pic][varchar](max) not null
)

CREATE TABLE [dbo].[activity](
[actID][int]PRIMARY KEY IDENTITY(001,1) not null,
[actTitle][varchar](max) not null,
[summary][varchar](max) not null,
[startDateTime][date] not null,
[endDateTime][date] not null
)
go

CREATE TABLE [dbo].[room](
[roomID][int] PRIMARY KEY IDENTITY,
[theaID][int] FOREIGN KEY (theaID) REFERENCES theater(theaID),
[roomType][int],
[roomName][varchar](4) not null,
[seat][varchar](1000),
[seatTotalRow][int] not null,
[seatTotalColumn][int] not null
)
go

CREATE TABLE [dbo].[roompic](
[roomPicID][int]PRIMARY KEY IDENTITY,
[roomID][int] FOREIGN KEY (roomID) REFERENCES room(roomID),
[pic][varchar](max) null
)

CREATE TABLE rounds(
	roundsID int IDENTITY(1, 1) PRIMARY KEY,
	roomID INT FOREIGN KEY (roomID) REFERENCES room(roomID),
	mvID INT FOREIGN KEY (mvID) REFERENCES movie(mvID),
	roundsDateTime DATETIME NOT NULL,
	--roundTime TIME, --NOT NULL,
	seat VARCHAR(1000),
)
GO

CREATE TABLE [dbo].[sales](
	[salesID] [int] IDENTITY(1,1) NOT NULL,
	[salesName] [varchar](10) NOT NULL,
	[account] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[theaID] [varchar](10) NULL,
	[activation] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[salesID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

create table ticketType
( 
typeID integer identity(1,1) primary key,
theaID integer foreign key references theater(theaID),
roomType integer,
typeName	varchar(20),
typePrice	decimal,
summary	varchar(max),
)

create table ticket
( 
	ticketID integer identity(1,1) primary key,
	roundsID integer foreign key references rounds(roundsID),
	seatRow		integer NOT NULL,
	seatColumn	integer NOT NULL,
	seatName varchar(5),
	mbID integer foreign key references member(mbID),
	salesID integer foreign key references sales(salesID),
	soldDateTime	datetime,
	orderedDateTime	datetime,
	price    decimal,
	typeID integer foreign key references ticketType(typeID),
)

