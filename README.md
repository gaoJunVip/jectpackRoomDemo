# jectpackRoomDemo
这是一个Room数据库的练习项目
一.创建数据库中的表
1.创建一个User 类,作为数据库的表.
2.@Entity(tableName = "table_user"),添加Entity标签,表明这是一个表.tableName可以指定表的名字,如果不指定,则表名就是类名
3.具体表中的字段创建可参考User类.

二.定义Dao接口文件,以完成对Entity的访问。注意:在文件的上方，需要加入@Dao标签。
1.创建一个接口UserDao.
2.创建对应的增删改查方法,具体使用方法参考UserDao文件.

三.创建数据库文件
1.创建一个AppDataBase抽象类,集成RoomDatabase.
2.在类上面添加@Database标签.表明这是一个数据库.
3.entities属性用于指定该数据库有哪些表，若需建立多张表，以逗号相隔开。version属性用于指定数据库版本号，后续数据库的升级正是依据版本号来判断的.
4.该类需要继承自RoomDatabase，在类中，通过Room.databaseBuilder()结合单例设计模式，完成数据库的创建工作。另外，我们创建的Dao对象，在这里以抽象方法的形式返回，只需一行代码即可。

