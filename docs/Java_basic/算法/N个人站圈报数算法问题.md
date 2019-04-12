
这是一道算法面试题
---
layout: post
title: N个人站圈报数算法问题
categories: Java语言核心
description: Java 网络编程技术 
keywords: Java-basic, 算法
---

本系列文章在 <https://github.com/freestylefly/javaStudy> 持(jing)续(chang)更(duan)新(geng)中，欢迎有兴趣的童鞋们关注。

```java
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;// 人数
		int m;// 报名数（报到的出列）
		

		System.out.print("请输入n：");
		n = input.nextInt();
		System.out.print("请输入m：");
		m = input.nextInt();
		int num = n;// 剩余人数
		int flag = 0;// 标记报名数，每报一次就加1
		int[] arr = new int[n];// 数组，刚开始所有数都为0,0代表存货，1代表删除该元素
		// 只要剩余人数大于等于1个人，就一直循环
		while (num >1) {
			for (int i = 0; i < n; i++) {
				if (arr[i] == 0) {
					flag++;
				}
				if (flag == m) {
					arr[i] = 1;
					System.out.println("第" + (i + 1) + "次出列：编号" + (i+1));
					flag=0;
					num--;
				}

			}
		}

		for (int i = 0; i < n; i++) {
			//最后编号为0代表存活的
			if(arr[i]==0) {
				System.out.println("最后剩下：" + (i+1));
			}
			
		}
	}
}

```

方式二：

```sql
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * 使用集合解决
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 人数
		int n;
		// 报名数（报到的出列）
		int m;
		//用来记录报名
		int count=0;
		System.out.print("请输入人数：");
		n = input.nextInt();
		System.out.print("请输入报到出列的数字：");
		m = input.nextInt();
		//集合放人和出列
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <=n; i++) {
			list.add(i);
		}
		
		while(list.size()>1) {
			for (int i = 0; i <list.size(); i++) {
				count++;
				
				//如果报数到m就讲这个数从集合中移出
				if(count==m) {
					System.out.println("出列的是："+list.remove(i));
					count=0;//重新开始报数
					i--;
				}
			}
		}

		//遍历集合看剩余谁
		for (int i = 0; i < list.size(); i++) {
			System.out.println("最后出列："+list.get(i));
		}
		
	}
}

```
------
# 本文章已同步至GitHub仓库：<a href="Javasthttps://github.com/freestylefly/javaStudyudy">Javastudy</a>,期待您的加入:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/github.jpg" width=""/>

# 本文章已同步至<a href="https://freestylefly.github.io/">苍何的个人博客</a>,可以直接在博客上留言哦:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/myblog..png" width=""/>

# 来我的微信公众号玩耍呗:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/weixingongzhonghao.jpg" width=""/>

# 扫码无套路关注我的CSDN博客:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/CSDN.png" width=""/>
