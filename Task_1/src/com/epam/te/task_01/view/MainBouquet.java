package com.epam.te.task_01.view;

import com.epam.te.task_01.controller.BouquetController;
import com.epam.te.task_01.controller.FlowerCommandName;
import com.epam.te.task_01.entity.bouquet.Bouquet;


/*Определить иерархию цветов. Создать несколько объектов цветов. Собрать букет (используя аксессуары)
 *  с определением его стоимости. Провести сортировку цветов в букете на основе уровня свежести. 
 *  Найти цветок в букете, соответствующий заданному диапазону длин стеблей
 */

public class MainBouquet {
	public static void main(String[] args){
		BouquetController c = new BouquetController();
		Bouquet b = c.execute(FlowerCommandName.CREATE_NEW_BOUQUET);
		System.out.println("Добавление цветов в букет");
		c.execute(FlowerCommandName.ADD_FLOWER, b, "peony", 60, 3);
		c.execute(FlowerCommandName.ADD_FLOWER, b, "CHRISANTEMUM", 57, 2);
		c.execute(FlowerCommandName.ADD_FLOWER, b, "MARIGOLD", 50, 4);
		System.out.println("Удаление цветов из букета");
		c.execute(FlowerCommandName.DELETE_FLOWER, b, "MARIGOLD", 2);
		c.execute(FlowerCommandName.DELETE_FLOWER, b, "rose", 2);
		System.out.println("Сортировка цветов в букете на основе уровня свежести");
		c.execute(FlowerCommandName.SORT_FLOWERS_BY_FRESHNESS, b);
		System.out.println("Найти цветок в букете по диапазону длин стеблей");
		c.execute(FlowerCommandName.FIND_FLOWER_LENGTH, b, 55, 60);
		System.out.println("Обрезать цветы в букете по одной заданной длине");
		c.execute(FlowerCommandName.CUT_ONE_LENGTH, b, 30);
		System.out.println("Добавим в букет аксессуаров: используем оберточный материал и ленту");
		c.execute(FlowerCommandName.ADD_LACE, b, "lace tape", "red", 25);
		c.execute(FlowerCommandName.ADD_PACKING, b, "nice pack", "white", "paper");
		System.out.println("--------------------------------");
		System.out.println("Стоимость букета");
		c.execute(FlowerCommandName.GET_BOUQUET_COST, b);
	}
}

