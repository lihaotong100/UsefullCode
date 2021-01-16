[TOC]
# 1.行为型模式
###1.1 Template Mehod Pattern(模板方法)
>类行为型模式
####1.1.1 定义
>"Template Mehod defines the skeleton of an algorithm in an operation deferring some steps to subclasses.Template
Method lets subclasses redefine certain steps of an algorithm without changing the  algorithm's
structure" --摘自《深入浅出设计模式》

`模板方法`主要用于规划一个算法框架类，他的所有子类行为都和此中定义步骤是一样的。同时对于一些可选步骤，我们利用hooks
来进行选择。在`模板方法`中，我们提取子类共有方法，将子类中一模一样的方法在父类(即提供算法框架的类)中实现，以此来代码重用(reuse)，
减少代码量。子类中不同的实现的函数，留给各个子类自己实现。同时，利用hooks来实现一些可有可无的方法。

###1.1.2 注意点
* 父类中，不可让子类重写的方法一定要加`final`
* `模板方法`是通过继承的方式来实现行为封装，`策略模式`是通过组合的方式来实现行为封装
