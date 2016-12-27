use master
/*病人表*/
CREATE TABLE Patient
(Pno CHAR(20) PRIMARY KEY,
 Pname CHAR(20),
 Psex CHAR(20),
 Pbirthday CHAR(20),/*出生年月*/
 Pplace CHAR(20),  /*出生地*/
 Pbirthplace CHAR(20),/*籍贯*/
 Pcondition CHAR(20),/*住院情况*/
 Pbudget CHAR(20)/*预支及费用*/
 );
/*医院员工表*/
CREATE TABLE Doctor
(Dname char(20) primary key,
 Dno char(20),
 Dage char(20),
 Dtelephone char(20),/*联系电话*/
 Dsex char(20),
 Drecord char(20),/*学历*/
 Dposition char(20),/*职务*/
 Djudgement char(900),/*自我评价*/
 Dexperience char(2000)/*工作经历*/
);
/*处方表*/
CREATE TABLE Presno
(  Presno char(20) primary key,
   Pcontent char(8000),/*处方内容*/
);
/*病人就医表*/
CREATE TABLE Hospitalize
(Pno CHAR(20),
 Pname CHAR(20),
 Dsubject CHAR(20),/*就医科别*/
 Dmdoctor CHAR(20),/*主治医生*/
 Dcause CHAR(20),/*病因*/
 Dpresno CHAR(20),/*处方编号*/
 Dpill CHAR(20),/*用药*/
 foreign key (Pno) references Patient(Pno),/*外键，引用病人表的Pno字段*/
 foreign key (Dpresno) references Presno(Presno)/*外键，引用处方表的Presno字段*/
);
/*病人收费表*/
CREATE TABLE Charge
(Pno CHAR(20),
 Cmedicine INT,/*药物收费*/
 Creg INT,/*挂号费*/
 Cdisposal INT,/*处置费*/
 Cexamine INT,/*化验费*/
 foreign key (Pno) references Patient(Pno)/*外键，引用病人表的Pno字段*/
);
/*药物表*/
CREATE TABLE Medicine
(Mno char(10) primary key,/*药物编号*/
 Mname CHAR(20) , /*药物名*/
 Mprice CHAR(20)     /*药物价格*/
  );
/*化验表*/
CREATE TABLE Examine
(Eno char(10) primary key,/*化验编号*/
 Ename CHAR(20) , /*化验名*/
 Eprice CHAR(20)/*化验价格*/
);
CREATE TABLE Guahao
(Pno CHAR(20),
 Pname CHAR(20),
 Dsubject CHAR(20),/*就医科别*/
 Dmdoctor CHAR(20),/*主治医生*/
 );







