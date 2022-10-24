#Игра "Змейка"
****
## Установка виртуальной среды
1. Находим в браузере **Microsoft Visual Studio**
2. Скачиваем **Visual Studio версию Community**
3. Устанавливаем
## Создание проекта
1. Открыть **Microsoft Visual Studio**
2. Выбрать язык **С#**
3. Выбрать **"Консольное приложение"**
4. Дать имя проекту
5. Указать расположение проекта
## Подготовка проекта
1. В созданном проекте прописать:
>using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

>namespace "*Имя вашего проекта*"
{
    internal class Program
    {
        static void Main(string[] args) {   
        }
    }
}
2. Скачать и установить библиотеку **"Small Basic"**
3. Подключаем библиотеку в наш проект:
    - Нажимаем правой кнопкой по окошку **"Ссылки"** в правой части экрана
    - Нажимаем **"Добавить ссылку"**
    - В открывшемся окне открываем вкладку **"Обзор"** и задаем путь к файлу **SmallBasicLibrary.dll**

4. В проекте, в самом верху прописать:
> using Microsoft.SmallBasic.Library;
## Написание кода
1. Для начала научим черепашку реагировать на нажатие клавиш. Пропишем:
   >GraphicsWindow.KeyDown += 

   И нажмем **"TAB"**. Создатся новая функция в которой пропишем обработку нажатий клавиш:
   - Команда **GraphicsWindow.LastKey == "Up"** отвечает за обработку нажатия клавиши **"↑"**
   - Команда **Turtle.Angle = 0** указывает на какой градус черепашка должна изменить своё направление движения

   В итоге должен получится такой код:
   >private static void GraphicsWindow_KeyDown()
        {
            if (GraphicsWindow.LastKey == "Up")
            {
                Turtle.Angle = 0;
            }
            else if (GraphicsWindow.LastKey == "Right")
            {
                Turtle.Angle = 90;
            }
            else if (GraphicsWindow.LastKey == "Down")
            {
                Turtle.Angle = 180;
            }
            else if (GraphicsWindow.LastKey == "Left")
            {
                Turtle.Angle = 270;
            }
        }
            
2. Далее пропишем **Turtle.PenUp();**, чтобы за черепашкой не оставался след
3. Добавим "еду" которую будет собирать черепашка:
    - Создадим объект "еды", который будет представлен в виде квадрата зеленого цвета размером 10 на 10 пикселей:
     >GraphicsWindow.BrushColor = "Green";
     var eat = Shapes.AddRectangle(10, 10);
    - И сделаем рандомную генерацию места появления "еды". Вычтем 10 единиц из координат Х и Y чтобы "еда" не появилась за границами экрана:
     >int koordX = new Random().Next(0, GraphicsWindow.Width-10);
      int koordY = new Random().Next(0, GraphicsWindow.Height-10); 
4. Инициализируем первое появление "еды" на поле, передав в функцию объект "еды" и его координаты:
   > Shapes.Move(eat, koordX, koordY);
5. Пропишем:
   >while (true){}

   и в фигурных скобках будем описывать поведение черепашки.
   - Пропишем скорость передвижения черепашки:
      >Turtle.Move(10);
   - Обработаем случай, при котром черепашка уходит за пределы экрана:
      >if (Turtle.Y > GraphicsWindow.Height)
                {
                    Turtle.Y = 0;
                }
                else if (Turtle.Y < 0)
                {
                    Turtle.Y = GraphicsWindow.Height;
                }
                if (Turtle.X > GraphicsWindow.Width)
                {
                    Turtle.X = 0;
                }
                else if (Turtle.X < 0)
                {
                    Turtle.X = GraphicsWindow.Width;
                }

     С помошью этого кода при выходе за пределы экрана, черепашка будет появляться с другой стороны экрана
   - Теперь обработаем случай подбора "еды" черепашкой:
   Пропишем что если координаты черепашки и координаты "еды" совпадают, то создается новый экзэмпляр еды, а скорость черепашки увеличивается
      >if (Turtle.X >= koordX && Turtle.X <= koordX + 10 && Turtle.Y >= koordY && Turtle.Y <= koordY + 10)
                {
                    koordX = new Random().Next(0, GraphicsWindow.Width-10);
                    koordY = new Random().Next(0, GraphicsWindow.Height-10);
                    Shapes.Move(eat, koordX, koordY);
                    Turtle.Speed++;
                }

##Игра готова! 