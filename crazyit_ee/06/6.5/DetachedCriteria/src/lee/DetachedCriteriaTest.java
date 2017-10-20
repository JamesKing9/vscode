package lee;

import org.hibernate.*;
import org.hibernate.criterion.*;

import java.util.*;

import org.crazyit.app.domain.*;

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
public class DetachedCriteriaTest
{
	public static void main(String[] args)
	{
		DetachedCriteriaTest pt = new DetachedCriteriaTest();
		pt.datached();
		pt.subQuery();
		HibernateUtil.sessionFactory.close();
	}

	// ִ�����߲�ѯ
	private void datached()
	{
		// ����һ�����߲�ѯ
		DetachedCriteria query = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ִ�����߲�ѯ
		List list = query.getExecutableCriteria(session)
			.list();
		// ������ѯ�Ľ��
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// ִ���Ӳ�ѯ
	private void subQuery()
	{
		// ����һ�����߲�ѯ
		DetachedCriteria subQuery = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// ��Session������
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// ִ���Ӳ�ѯ
		List list = session.createCriteria(Student.class)
			// �������д����������ͬ����ʾ����ͨ���Ӳ�ѯ���Ӳ�ѯ����
			.add( Property.forName("name").in(subQuery))
//			.add( Subqueries.propertyIn("name" , subQuery))
			.list();
		// ������ѯ�Ľ��
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}