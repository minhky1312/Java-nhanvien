import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        List<Nhanvien> nhanvien = new ArrayList<Nhanvien>();

        Scanner sc = new Scanner(System.in);
        String name="";
        int age=0;
        int salary=0;
        boolean check=false;

        int count2=1;
        System.out.println("Nhập số lượng nhân viên: ");
        try
        {
            count2=sc.nextInt();
            sc.nextLine();
            while (check==false)
            {
                if(count2<=0)
                {
                    System.out.println("Số không hợp lệ");
                    System.out.println("Nhập lại số");
                }
                else
                {
                    check=true;
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Không được nhập kí tự");
        }
        check=false;
        //Bắt đầu nhập nhân viên
        for (int j=1;j<=count2;j++)
        {
            check=false;
            System.out.println("Nhân viên thứ "+j+"\n"+"\n");
            System.out.println("Nhập tên: ");
            while(check==false)
            {  name= sc.nextLine();
                if (name.matches(".*[0-9].*")==true) {
                    System.out.println("Không nhập kí tự số trong tên!");
                    System.out.println("Nhập lại tên: ");
                }
                else
                {
                    if (name.matches(".*[\\s].*")!=true){
                        System.out.println(" Ghi đủ họ tên");
                        System.out.println("Nhập lại tên: ");
                    }
                    else
                    {
                        char ch[] = name.toCharArray();
                        boolean c=false;
                        for(int i=0;i<ch.length;i++)
                        {
                            if(testChar(ch[i])) c=true;
                        }
                        if(c) {
                            System.out.println("có kí tự đặc biệt");
                            System.out.println("Nhập lại tên: ");
                        }
                        else
                        {
                            System.out.println("Hoàn thành nhập tên");
                            check=true;
                        }

                    }


                }

            }
            System.out.println("Nhập tuổi: ");
            check=false;
            while(check==false)
            {
                try
                {
                    age=sc.nextInt();
                    sc.nextLine();
                    if(age<=16) {
                        System.out.println("Số tuổi không hợp lệ");
                        System.out.println("Nhập lại tuổi");
                    }
                    else
                    {
                        if (age>58) {
                            System.out.println("Tuổi về hưu");
                            System.out.println("Nhập lại tuổi");
                        }
                        else
                        {
                            check=true;
                            System.out.println("Hoàn thành nhập tuổi");
                        }
                    }

                }
                catch (InputMismatchException e)
                {
                    System.out.println("Không được nhập kí tự");
                }

            }

            System.out.println("Nhập lương: ");
            check=false;
            while(check==false)
            {
                try
                {
                    salary=sc.nextInt();
                    sc.nextLine();
                    if(salary<=0) {
                        System.out.println("Số lương không hợp lệ");
                        System.out.println("Nhập lại lương");
                    }
                    else
                    {
                        check=true;
                        System.out.println("Hoàn thành nhập lương");
                    }

                }
                catch (InputMismatchException e)
                {
                    System.out.println("Không được nhập kí tự");
                }

            }
            Nhanvien nv = new Nhanvien(name,age,salary);
            nhanvien.add(nv);
        }


        try
        {
            FileWriter f2 = new FileWriter("F:/Nhanvien.txt");
            int count=1;
            f2.write("                                THÔNG TIN NHÂN VIÊN      " +"\n"+"\n"+"\n"+"\n");
            for (Nhanvien nhanvien1 : nhanvien) {
               f2.write("         Nhân viên thứ "+count
                      +"\n"+" Tên nhân viên: "+nhanvien1.getName()
                       +"\n"+" Tuổi: "+nhanvien1.getAge()
                        +"\n"+" Lương: "+nhanvien1.getSalary()
               +"\n"+"    -----------    "
               +"\n" +"\n" );
               count+=1;
            }
            f2.close();
        }
        catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }

        try
        {
            File f = new File("F:/Nhanvien.txt");
            if(f.createNewFile())
            {
                System.out.println("File"+ f.getName() + " add! ");
            }
            else
            {
                System.out.println("File Already Exists");
            }
            Scanner read = new Scanner(f);
            String data="";
            while (read.hasNextLine())
            {
                data=read.nextLine();
                System.out.println(data);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }


    }

    static public boolean testChar(char ch)
    {
        char kt[]= { '!', '@' ,'#' ,'$','%','&','^','*','(',')','-','+','{','}','[',']','|'};
        boolean b=false;
        for (char i:kt)
        {
            if(i==ch) b=true;
        }
        return b;
    }
}
