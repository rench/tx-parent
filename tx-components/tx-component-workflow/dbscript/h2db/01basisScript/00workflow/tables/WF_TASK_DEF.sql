--****************************************************************************
-- workflow��������ʵ����Ϣ��
--****************************************************************************
create table wf_task_def
(
	id varchar(64) not null,              --����������
	parentId varchar(64) not null,        --�������񸸽ڵ�id
	wftkdkey varchar(64) not null,        --����������:ӳ��ʵ�������е�key
	wfdId varchar(64) not null,           --���̶���id
	name varchar(64) not null,            --���̻�����
	alise varchar(64),                    --���̻��ڱ���
	taskorder integer default 0,          --���̻���˳��
	taskType varchar(64),                 --�ڵ���������
	serviceType varchar(64),              --ҵ������
	isViewAble integer default 1,         --�����Ƿ�ɼ���1���ɼ�
 	primary key(id)
);
create unique index idx_wf_task_def_01 on wf_task_def(wfkey,version);