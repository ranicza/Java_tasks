package com.epam.te.task_01.view;

import com.epam.te.task_01.controller.BouquetController;
import com.epam.te.task_01.controller.FlowerCommandName;
import com.epam.te.task_01.entity.bouquet.Bouquet;


/*���������� �������� ������. ������� ��������� �������� ������. ������� ����� (��������� ����������)
 *  � ������������ ��� ���������. �������� ���������� ������ � ������ �� ������ ������ ��������. 
 *  ����� ������ � ������, ��������������� ��������� ��������� ���� �������
 */

public class MainBouquet {
	public static void main(String[] args){
		BouquetController c = new BouquetController();
		Bouquet b = c.execute(FlowerCommandName.CREATE_NEW_BOUQUET);
		System.out.println("���������� ������ � �����");
		c.execute(FlowerCommandName.ADD_FLOWER, b, "peony", 60, 3);
		c.execute(FlowerCommandName.ADD_FLOWER, b, "CHRISANTEMUM", 57, 2);
		c.execute(FlowerCommandName.ADD_FLOWER, b, "MARIGOLD", 50, 4);
		System.out.println("�������� ������ �� ������");
		c.execute(FlowerCommandName.DELETE_FLOWER, b, "MARIGOLD", 2);
		c.execute(FlowerCommandName.DELETE_FLOWER, b, "rose", 2);
		System.out.println("���������� ������ � ������ �� ������ ������ ��������");
		c.execute(FlowerCommandName.SORT_FLOWERS_BY_FRESHNESS, b);
		System.out.println("����� ������ � ������ �� ��������� ���� �������");
		c.execute(FlowerCommandName.FIND_FLOWER_LENGTH, b, 55, 60);
		System.out.println("�������� ����� � ������ �� ����� �������� �����");
		c.execute(FlowerCommandName.CUT_ONE_LENGTH, b, 30);
		System.out.println("������� � ����� �����������: ���������� ���������� �������� � �����");
		c.execute(FlowerCommandName.ADD_LACE, b, "lace tape", "red", 25);
		c.execute(FlowerCommandName.ADD_PACKING, b, "nice pack", "white", "paper");
		System.out.println("--------------------------------");
		System.out.println("��������� ������");
		c.execute(FlowerCommandName.GET_BOUQUET_COST, b);
	}
}

