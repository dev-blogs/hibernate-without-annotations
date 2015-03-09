PATH_TO_PROJECT=`pwd`
   
# Удаляем каталог с предыдущим билдом
if test -d $PATH_TO_PROJECT/build;
then
    rm -rf $PATH_TO_PROJECT/build
fi
    
# Создаем новый каталог, куда будем помещать билд
mkdir $PATH_TO_PROJECT/build
        
# Компилируем проект в каталог build
# Для компиляции достаточно библиотеки spring-2.5.5.jar
javac -d build -cp .:lib/* src/main/java/DAO/impl/*.java src/main/java/DAO/*.java src/main/java/com/dev/blogs/hibernate/*.java src/main/java/model/*.java src/main/java/util/*.java
    
# Выполняем приложение
# Для выполнения приложения к библиотеке spring-2.5.5.jar
# добавим еще библиотеку commons-logging-1.1.3.jar для логирования
java -cp .:build:resources:lib/* com.dev.blogs.hibernate.App
