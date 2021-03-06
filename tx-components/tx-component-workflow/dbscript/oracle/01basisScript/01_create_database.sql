prompt EXECUTE createdatabase orasql..
--DROP TABLESPACE WD_DAT INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;
--DROP TABLESPACE WD_IDX INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;
--DROP TABLESPACE WD_LOG_DAT INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;
--DROP TABLESPACE WD_LOG_IDX INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;
--DROP TABLESPACE WD_TEMP INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;
--DROP TABLESPACE WD_RBS INCLUDING CONTENTS AND DATAFILES CASCADE CONSTRAINTS;

CREATE TABLESPACE WD_DAT
DATAFILE
  'D:\oracle\database\WD_1G_DAT01' SIZE 1024M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_2G_DAT01' SIZE 2048M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\WD_2G_DAT10' SIZE 2048M REUSE AUTOEXTEND OFF
  LOGGING
  ONLINE
  PERMANENT
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 2M
/
CREATE TABLESPACE WD_IDX
DATAFILE
'D:\oracle\database\WD_1G_IDX01' SIZE 1024M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_2G_IDX01' SIZE 2048M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\WD_2G_IDX10' SIZE 2048M REUSE AUTOEXTEND OFF
  LOGGING
  ONLINE
  PERMANENT
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1M
/
CREATE TABLESPACE WD_LOG_DAT
DATAFILE
'D:\oracle\database\WD_LOG_512M_DAT01' SIZE 512M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_LOG_2G_DAT01' SIZE 2048M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\WD_LOG_2G_DAT06' SIZE 2048M REUSE AUTOEXTEND OFF  
  LOGGING
  ONLINE
  PERMANENT
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1M
/
CREATE TABLESPACE WD_LOG_IDX
DATAFILE
'D:\oracle\database\WD_LOG_512M_IDX01' SIZE 512M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_LOG_2G_IDX01' SIZE 2048M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\WD_LOG_2G_IDX06' SIZE 2048M REUSE AUTOEXTEND OFF
  LOGGING
  ONLINE
  PERMANENT
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1M
/
CREATE TEMPORARY TABLESPACE WD_TEMP
TEMPFILE
'D:\oracle\database\WD_256M_TEMP01' SIZE 256M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_512M_TEMP01' SIZE 512M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\WD_512M_TEMP04' SIZE 512M REUSE AUTOEXTEND OFF
  EXTENT MANAGEMENT LOCAL UNIFORM SIZE 1M
/
--UNDO TABLESPACE
CREATE UNDO TABLESPACE WD_RBS
DATAFILE
'D:\oracle\database\WD_256M_RBS01' SIZE 256M REUSE AUTOEXTEND OFF
--  'D:\oracle\database\WD_2G_RBS01' SIZE 2048M REUSE AUTOEXTEND OFF,
--  'D:\oracle\database\IISS_RBS02' SIZE 2048M REUSE AUTOEXTEND OFF
ONLINE
/
prompt EXECUTE orasql...DONE.

EXIT;