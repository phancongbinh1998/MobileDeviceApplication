USE [master]
GO
/****** Object:  Database [MobileDevice]    Script Date: 6/23/2018 5:22:05 PM ******/
CREATE DATABASE [MobileDevice]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MobileDevice', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.BINHPCSE62805\MSSQL\DATA\MobileDevice.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'MobileDevice_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.BINHPCSE62805\MSSQL\DATA\MobileDevice_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [MobileDevice] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MobileDevice].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MobileDevice] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MobileDevice] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MobileDevice] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MobileDevice] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MobileDevice] SET ARITHABORT OFF 
GO
ALTER DATABASE [MobileDevice] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MobileDevice] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MobileDevice] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MobileDevice] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MobileDevice] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MobileDevice] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MobileDevice] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MobileDevice] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MobileDevice] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MobileDevice] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MobileDevice] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MobileDevice] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MobileDevice] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MobileDevice] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MobileDevice] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MobileDevice] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MobileDevice] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MobileDevice] SET RECOVERY FULL 
GO
ALTER DATABASE [MobileDevice] SET  MULTI_USER 
GO
ALTER DATABASE [MobileDevice] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MobileDevice] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MobileDevice] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MobileDevice] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [MobileDevice] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'MobileDevice', N'ON'
GO
ALTER DATABASE [MobileDevice] SET QUERY_STORE = OFF
GO
USE [MobileDevice]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [MobileDevice]
GO
/****** Object:  Table [dbo].[tbl_Mobile]    Script Date: 6/23/2018 5:22:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Mobile](
	[mobileId] [varchar](10) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[price] [float] NULL,
	[mobileName] [varchar](20) NOT NULL,
	[yearOfProduction] [int] NULL,
	[quantity] [int] NULL,
	[notSale] [bit] NULL,
 CONSTRAINT [PK_tbl_Mobile] PRIMARY KEY CLUSTERED 
(
	[mobileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Order]    Script Date: 6/23/2018 5:22:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Order](
	[orderId] [varchar](10) NOT NULL,
	[mobileName] [varchar](20) NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tbl_Oder] PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 6/23/2018 5:22:05 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[userId] [varchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [varchar](50) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'465', N'zxc', 123, N'zxc', 123, 12, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M01', N'red', 340, N'Samsung galaxy', 10, 20, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M02', N'deep blue', 270, N'Nokia', 5, 10, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M03', N'black', 500, N'Galaxy X', 10, 40, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M04', N'pink', 150, N'Nokia Note', 7, 7, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M05', N'hot pink', 230, N'Lumia', 12, 14, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M06', N'grey', 420, N'Opera', 4, 12, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M07', N'purple', 142, N'Sunshiue', 2014, 26, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'M08', N'white', 156, N'ShiroPhone', 2017, 50, 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'admin', 123456, N'ADMIN', 2)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'binh', 123456, N'Binh', 1)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'hai', 789, N'Hai', 1)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'hieu', 123456, N'Hieu', 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'quan', 123, N'Quan', 0)
ALTER TABLE [dbo].[tbl_Order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Order_tbl_Mobile] FOREIGN KEY([orderId])
REFERENCES [dbo].[tbl_Mobile] ([mobileId])
GO
ALTER TABLE [dbo].[tbl_Order] CHECK CONSTRAINT [FK_tbl_Order_tbl_Mobile]
GO
USE [master]
GO
ALTER DATABASE [MobileDevice] SET  READ_WRITE 
GO
