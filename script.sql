
/****** Object:  Database [swp]    Script Date: 11/2/2022 4:59:11 PM ******/
CREATE DATABASE [swp]

GO
ALTER DATABASE [swp] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [swp].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [swp] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [swp] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [swp] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [swp] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [swp] SET ARITHABORT OFF 
GO
ALTER DATABASE [swp] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [swp] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [swp] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [swp] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [swp] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [swp] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [swp] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [swp] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [swp] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [swp] SET  ENABLE_BROKER 
GO
ALTER DATABASE [swp] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [swp] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [swp] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [swp] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [swp] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [swp] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [swp] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [swp] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [swp] SET  MULTI_USER 
GO
ALTER DATABASE [swp] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [swp] SET DB_CHAINING OFF 
GO
ALTER DATABASE [swp] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [swp] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [swp] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [swp] SET QUERY_STORE = OFF
GO
USE [swp]
GO
/****** Object:  Table [dbo].[account]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[id_type] [int] NOT NULL,
	[username] [nvarchar](255) NOT NULL,
	[password] [nvarchar](255) NOT NULL,
	[avatar] [nvarchar](50) NULL,
 CONSTRAINT [PK_tai_khoan] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[account_type]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account_type](
	[account_type_id] [int] IDENTITY(1,1) NOT NULL,
	[type_name] [nvarchar](255) NULL,
 CONSTRAINT [PK_loai_tai_khoan] PRIMARY KEY CLUSTERED 
(
	[account_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[area]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[area](
	[area_id] [int] IDENTITY(1,1) NOT NULL,
	[area_name] [nvarchar](255) NULL,
	[area_address] [nvarchar](255) NULL,
	[contact] [nvarchar](45) NULL,
 CONSTRAINT [PK_khu_cach_ly] PRIMARY KEY CLUSTERED 
(
	[area_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id_category] [int] NOT NULL,
	[category_name] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[id_category] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category_medicine]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category_medicine](
	[category_id] [int] NOT NULL,
	[medicine_id] [int] NOT NULL,
	[id] [int] NOT NULL,
 CONSTRAINT [PK_category_medicine] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[doctor]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doctor](
	[id_doctor] [int] NOT NULL,
	[doctor_name] [nvarchar](255) NOT NULL,
	[phone] [int] NOT NULL,
	[fullname] [nvarchar](255) NOT NULL,
	[id_account] [int] NOT NULL,
	[address] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_doctor] PRIMARY KEY CLUSTERED 
(
	[id_doctor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[doctor_patient]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doctor_patient](
	[patient_id] [int] NOT NULL,
	[id_doctor] [int] NOT NULL,
	[id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[medicine]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[medicine](
	[id_medicine] [int] NOT NULL,
	[medicine_name] [nvarchar](255) NOT NULL,
	[quantity] [int] NOT NULL,
	[image] [text] NULL,
 CONSTRAINT [PK_medicine] PRIMARY KEY CLUSTERED 
(
	[id_medicine] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nurse]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nurse](
	[id_nurse] [int] NOT NULL,
	[name_nurse] [nvarchar](255) NOT NULL,
	[phone] [int] NOT NULL,
	[fullname] [nvarchar](255) NOT NULL,
	[id_account] [int] NOT NULL,
	[address] [nvarchar](255) NULL,
 CONSTRAINT [PK_nurse] PRIMARY KEY CLUSTERED 
(
	[id_nurse] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nurse_patient]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nurse_patient](
	[patient_id] [int] NOT NULL,
	[id_nurse] [int] NOT NULL,
	[id] [int] NOT NULL,
 CONSTRAINT [PK_nurse_patient] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[patient]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[patient](
	[patient_id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [varchar](255) NULL,
	[age] [int] NULL,
	[gender] [nvarchar](50) NULL,
	[address] [nvarchar](255) NULL,
	[partpost] [nvarchar](50) NULL,
	[phone] [int] NULL,
	[region] [nvarchar](50) NULL,
	[suspicion_level] [nvarchar](50) NOT NULL,
	[time_in] [datetime] NOT NULL,
	[time_out] [datetime] NULL,
	[room_id] [int] NOT NULL,
	[area_id] [int] NULL,
	[account_id] [int] NULL,
 CONSTRAINT [PK_nguoi_cach_ly] PRIMARY KEY CLUSTERED 
(
	[patient_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[patient_room]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[patient_room](
	[id_patient_room] [int] NULL,
	[id_patient] [int] NULL,
	[id_room] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[prescription]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[prescription](
	[id_prescription] [int] IDENTITY(1,1) NOT NULL,
	[medicine_name] [nvarchar](255) NULL,
	[create_date] [datetime] NULL,
	[id_patient] [int] NOT NULL,
	[id_doctor] [int] NOT NULL,
	[id_medicine] [int] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_don_thuoc] PRIMARY KEY CLUSTERED 
(
	[id_prescription] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[report]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[report](
	[id_report] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](255) NULL,
	[create_date] [datetime] NULL,
	[id_patient] [int] NOT NULL,
 CONSTRAINT [PK_bao_cao] PRIMARY KEY CLUSTERED 
(
	[id_report] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[room]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[room_id] [int] IDENTITY(1,1) NOT NULL,
	[room_name] [nvarchar](50) NULL,
	[bad_number] [nvarchar](50) NULL,
	[note] [nvarchar](255) NULL,
	[area_id] [int] NULL,
 CONSTRAINT [PK_phong] PRIMARY KEY CLUSTERED 
(
	[room_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[test_result]    Script Date: 11/2/2022 4:59:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_result](
	[test_result_id] [int] IDENTITY(1,1) NOT NULL,
	[patient_id] [int] NULL,
	[test_name] [nvarchar](45) NULL,
	[result] [nvarchar](255) NULL,
	[create_date] [datetime] NULL,
 CONSTRAINT [PK_kq_xet_nghiem] PRIMARY KEY CLUSTERED 
(
	[test_result_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([account_id], [id_type], [username], [password], [avatar]) VALUES (7, 3, N'danggiang', N'9c7a274a488966e9372b2e5fd3ff41a4', NULL)
INSERT [dbo].[account] ([account_id], [id_type], [username], [password], [avatar]) VALUES (28, 3, N'huy', N'9c7a274a488966e9372b2e5fd3ff41a4', N'avatar-default.png')
INSERT [dbo].[account] ([account_id], [id_type], [username], [password], [avatar]) VALUES (30, 3, N'minh', N'9c7a274a488966e9372b2e5fd3ff41a4', N'avatar-default.png')
INSERT [dbo].[account] ([account_id], [id_type], [username], [password], [avatar]) VALUES (31, 3, N'hai', N'9c7a274a488966e9372b2e5fd3ff41a4', N'avatar-default.png')
SET IDENTITY_INSERT [dbo].[account] OFF
GO
SET IDENTITY_INSERT [dbo].[account_type] ON 

INSERT [dbo].[account_type] ([account_type_id], [type_name]) VALUES (1, N'manager')
INSERT [dbo].[account_type] ([account_type_id], [type_name]) VALUES (2, N'staff')
INSERT [dbo].[account_type] ([account_type_id], [type_name]) VALUES (3, N'user')
INSERT [dbo].[account_type] ([account_type_id], [type_name]) VALUES (4, N'doctor')
SET IDENTITY_INSERT [dbo].[account_type] OFF
GO
SET IDENTITY_INSERT [dbo].[area] ON 

INSERT [dbo].[area] ([area_id], [area_name], [area_address], [contact]) VALUES (1, N'Khu cách ly Nghĩa Hiệp', N'Số 25, Trần Hưng Đạo, Hà Nội', N'0987654321')
INSERT [dbo].[area] ([area_id], [area_name], [area_address], [contact]) VALUES (2, N'Khu cách ly Bình Tân', N'Số 12, Quận 1, Thành phố Hồ Chí Minh', N'0912345678')
INSERT [dbo].[area] ([area_id], [area_name], [area_address], [contact]) VALUES (3, N'Khu cách ly Xã Đàn', N'Số 1, Lê Duẩn, Hà Nội', N'0123459876')
SET IDENTITY_INSERT [dbo].[area] OFF
GO
SET IDENTITY_INSERT [dbo].[patient] ON 

INSERT [dbo].[patient] ([patient_id], [full_name], [age], [gender], [address], [partpost], [phone], [region], [suspicion_level], [time_in], [time_out], [room_id], [area_id], [account_id]) VALUES (1, N'nguy?n dang giang', 18, N'nam', N'hà nội', N'001200020739', 988025083, N'vietnam', N'F1', CAST(N'2022-06-04T01:02:03.000' AS DateTime), CAST(N'2022-01-08T23:38:35.000' AS DateTime), 1, 1, NULL)
INSERT [dbo].[patient] ([patient_id], [full_name], [age], [gender], [address], [partpost], [phone], [region], [suspicion_level], [time_in], [time_out], [room_id], [area_id], [account_id]) VALUES (2, N'van huy', 18, N'nu', N'ha noi', N'09880834959834984', 987654321, N'vietnam', N'F1', CAST(N'2021-06-04T01:02:03.000' AS DateTime), NULL, 1, 1, NULL)
INSERT [dbo].[patient] ([patient_id], [full_name], [age], [gender], [address], [partpost], [phone], [region], [suspicion_level], [time_in], [time_out], [room_id], [area_id], [account_id]) VALUES (5, N'minh', 18, N'nam', N'ha noi', N'944359379847539873', 987654321, N'vietnam', N'f1', CAST(N'2021-05-12T01:02:03.000' AS DateTime), NULL, 1, 1, 30)
INSERT [dbo].[patient] ([patient_id], [full_name], [age], [gender], [address], [partpost], [phone], [region], [suspicion_level], [time_in], [time_out], [room_id], [area_id], [account_id]) VALUES (7, N'hai', 18, N'nam', N'ha noi', N'7987357933329', 489784972, N'vietnam', N'f1', CAST(N'2021-05-12T01:02:03.000' AS DateTime), NULL, 1, 1, 31)
SET IDENTITY_INSERT [dbo].[patient] OFF
GO
SET IDENTITY_INSERT [dbo].[report] ON 

INSERT [dbo].[report] ([id_report], [content], [create_date], [id_patient]) VALUES (1, N'ok', CAST(N'2022-02-10T00:00:00.000' AS DateTime), 5)
INSERT [dbo].[report] ([id_report], [content], [create_date], [id_patient]) VALUES (2, N'ok', CAST(N'2022-02-10T00:00:00.000' AS DateTime), 5)
INSERT [dbo].[report] ([id_report], [content], [create_date], [id_patient]) VALUES (3, N'ho sot', CAST(N'2022-02-11T00:00:00.000' AS DateTime), 7)
SET IDENTITY_INSERT [dbo].[report] OFF
GO
SET IDENTITY_INSERT [dbo].[room] ON 

INSERT [dbo].[room] ([room_id], [room_name], [bad_number], [note], [area_id]) VALUES (1, N'A1', N'10', N'ABC', 1)
SET IDENTITY_INSERT [dbo].[room] OFF
GO
SET IDENTITY_INSERT [dbo].[test_result] ON 

INSERT [dbo].[test_result] ([test_result_id], [patient_id], [test_name], [result], [create_date]) VALUES (1, 1, N'test covid', N'duong tinh', CAST(N'2021-06-04T01:02:03.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[test_result] OFF
GO
ALTER TABLE [dbo].[category_medicine]  WITH CHECK ADD  CONSTRAINT [FK_category_medicine_category] FOREIGN KEY([category_id])
REFERENCES [dbo].[category] ([id_category])
GO
ALTER TABLE [dbo].[category_medicine] CHECK CONSTRAINT [FK_category_medicine_category]
GO
ALTER TABLE [dbo].[category_medicine]  WITH CHECK ADD  CONSTRAINT [FK_category_medicine_medicine] FOREIGN KEY([medicine_id])
REFERENCES [dbo].[medicine] ([id_medicine])
GO
ALTER TABLE [dbo].[category_medicine] CHECK CONSTRAINT [FK_category_medicine_medicine]
GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD FOREIGN KEY([id_account])
REFERENCES [dbo].[account] ([account_id])
GO
ALTER TABLE [dbo].[doctor_patient]  WITH CHECK ADD  CONSTRAINT [FK_doctor_patient_doctor] FOREIGN KEY([id_doctor])
REFERENCES [dbo].[doctor] ([id_doctor])
GO
ALTER TABLE [dbo].[doctor_patient] CHECK CONSTRAINT [FK_doctor_patient_doctor]
GO
ALTER TABLE [dbo].[doctor_patient]  WITH CHECK ADD  CONSTRAINT [FK_doctor_patient_patient] FOREIGN KEY([patient_id])
REFERENCES [dbo].[patient] ([patient_id])
GO
ALTER TABLE [dbo].[doctor_patient] CHECK CONSTRAINT [FK_doctor_patient_patient]
GO
ALTER TABLE [dbo].[nurse]  WITH CHECK ADD FOREIGN KEY([id_account])
REFERENCES [dbo].[account] ([account_id])
GO
ALTER TABLE [dbo].[nurse_patient]  WITH CHECK ADD  CONSTRAINT [FK_nurse_patient_nurse] FOREIGN KEY([id_nurse])
REFERENCES [dbo].[nurse] ([id_nurse])
GO
ALTER TABLE [dbo].[nurse_patient] CHECK CONSTRAINT [FK_nurse_patient_nurse]
GO
ALTER TABLE [dbo].[nurse_patient]  WITH CHECK ADD  CONSTRAINT [FK_nurse_patient_patient] FOREIGN KEY([patient_id])
REFERENCES [dbo].[patient] ([patient_id])
GO
ALTER TABLE [dbo].[nurse_patient] CHECK CONSTRAINT [FK_nurse_patient_patient]
GO
ALTER TABLE [dbo].[patient]  WITH CHECK ADD  CONSTRAINT [FK_patient_account] FOREIGN KEY([account_id])
REFERENCES [dbo].[account] ([account_id])
GO
ALTER TABLE [dbo].[patient] CHECK CONSTRAINT [FK_patient_account]
GO
ALTER TABLE [dbo].[patient_room]  WITH CHECK ADD  CONSTRAINT [FK_patient_room_patient] FOREIGN KEY([id_patient])
REFERENCES [dbo].[patient] ([patient_id])
GO
ALTER TABLE [dbo].[patient_room] CHECK CONSTRAINT [FK_patient_room_patient]
GO
ALTER TABLE [dbo].[patient_room]  WITH CHECK ADD  CONSTRAINT [FK_patient_room_room] FOREIGN KEY([id_room])
REFERENCES [dbo].[room] ([room_id])
GO
ALTER TABLE [dbo].[patient_room] CHECK CONSTRAINT [FK_patient_room_room]
GO
ALTER TABLE [dbo].[prescription]  WITH CHECK ADD  CONSTRAINT [FK_prescription_doctor] FOREIGN KEY([id_doctor])
REFERENCES [dbo].[doctor] ([id_doctor])
GO
ALTER TABLE [dbo].[prescription] CHECK CONSTRAINT [FK_prescription_doctor]
GO
ALTER TABLE [dbo].[prescription]  WITH CHECK ADD  CONSTRAINT [FK_prescription_medicine] FOREIGN KEY([id_medicine])
REFERENCES [dbo].[medicine] ([id_medicine])
GO
ALTER TABLE [dbo].[prescription] CHECK CONSTRAINT [FK_prescription_medicine]
GO
ALTER TABLE [dbo].[report]  WITH CHECK ADD  CONSTRAINT [FK__bao_cao__id_nguo__589C25F3] FOREIGN KEY([id_patient])
REFERENCES [dbo].[patient] ([patient_id])
GO
ALTER TABLE [dbo].[report] CHECK CONSTRAINT [FK__bao_cao__id_nguo__589C25F3]
GO
ALTER TABLE [dbo].[room]  WITH CHECK ADD  CONSTRAINT [FK__phong__id_khu_ca__56B3DD81] FOREIGN KEY([area_id])
REFERENCES [dbo].[area] ([area_id])
GO
ALTER TABLE [dbo].[room] CHECK CONSTRAINT [FK__phong__id_khu_ca__56B3DD81]
GO
ALTER TABLE [dbo].[test_result]  WITH CHECK ADD  CONSTRAINT [FK__kq_xet_ng__id_ng__54CB950F] FOREIGN KEY([patient_id])
REFERENCES [dbo].[patient] ([patient_id])
GO
ALTER TABLE [dbo].[test_result] CHECK CONSTRAINT [FK__kq_xet_ng__id_ng__54CB950F]
GO
USE [master]
GO
ALTER DATABASE [swp] SET  READ_WRITE 
GO
