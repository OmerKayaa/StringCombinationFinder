package View;

import java.util.List;

public class ConsoleView
{
    private final int width,attribute;
    private int CurrentRow=0,CurrentColumn=0;

    public ConsoleView(int Width,String... Title)
    {
        width = Width; attribute = Title.length;
        printLine();
        AddRow(Title);
    }

    private void AddRow(String... RowAttribute)
    {
        for (String title: RowAttribute)
        {
            System.out.printf("|%"+(width)+"s",title);
        }
        System.out.println("|");
        printLine();
    }

    private void AddColumn(String string)
    {
        System.out.printf("|%"+(width)+"s",string);
        CurrentColumn += 1;
        if(CurrentColumn % attribute == 0)
        {
            System.out.println("|");
            printLine();
            CurrentRow ++;
        }
    }

    private void printPlus()
    {
        System.out.print("+");
    }

    private void printLine()
    {
        for (int i = 0; i < attribute ; i++)
        {
            printPlus();
            for (int j = 0; j < width-1; j+=2)
            {
                System.out.print("--");
            }
        }
        System.out.println("+");
    }

    public class tableAttributes
    {
        public tableAttributes(List<String>... lists )
        {
            if(lists.length != attribute)
            {
                throw new ArrayIndexOutOfBoundsException("Table attribute should be same size as table title");
            }
            for(boolean con = true; con ;)
            {
                con = false;
                for (List<String> list: lists)
                {
                    con |= CurrentRow < list.size();
                }
                if(!con) break;
                else
                {
                    for (List<String> list: lists)
                    {
                        AddColumn(list.size()>CurrentRow?list.get(CurrentRow):"");
                    }
                }
            }
        }
    }
}
