package org.crazyit.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationEvent;

import org.crazyit.app.event.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class EmailNotifier implements ApplicationListener
{
	// �÷����������������¼�ʱ�Զ�����
	public void onApplicationEvent(ApplicationEvent evt)
	{
		// ֻ����EmailEvent��ģ�ⷢ��email֪ͨ...
		if (evt instanceof EmailEvent)
		{
			EmailEvent emailEvent = (EmailEvent)evt;
			System.out.println("��Ҫ�����ʼ��Ľ��յ�ַ  "
				+ emailEvent.getAddress());
			System.out.println("��Ҫ�����ʼ����ʼ�����  "
				+ emailEvent.getText());
		}
		else
		{
			// �����¼������κδ���
			System.out.println("�����¼���" + evt);
		}
	}
}