package src.office;

public class OfficeTest {
    public static void main(String[] args) {
        Office office1 = new Office(-1600.5, "Blake");
        office1.size = -1600.5;
        // office1.name = "Blake";
        System.out.println(office1.getSize());
        office1.setSize(900);
        System.out.println(office1.getSize());
    }
}
