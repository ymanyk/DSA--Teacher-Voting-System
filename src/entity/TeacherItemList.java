package entity;

import adt.ArrayListForTeacher;

/**
 *
 * @author Yong Man Kei
 */

public class TeacherItemList {

    private ArrayListForTeacher<EachTeacherList> itemList = new ArrayListForTeacher<>(10);
    private int subtotal;

    public TeacherItemList() {
        this.subtotal = 0;
    }

    public void addItemList(TeacherList tl) {

        int listIndex = -1;
        for (int j = 0; j < itemList.getNumberOfEntries(); j++) {
            //change the quantity with following itemID if the list is not empty and same item
            if (!itemList.isEmpty() && tl.getTeacherId().equals(itemList.getEntry(j + 1).getTeacherID())) {
                listIndex = j;
                break;
            }
        }

        if (listIndex != -1) {
            subtotal -= itemList.getEntry(listIndex + 1).getVote();
            itemList.getEntry(listIndex + 1).setVote(itemList.getEntry(listIndex + 1).getVote() + tl.getVote());
            itemList.getEntry(listIndex + 1).calSubtotal();
            subtotal += itemList.getEntry(listIndex + 1).getVote();
        } else {
            itemList.add(new EachTeacherList(tl.getTeacherId(), tl.getTeacherName(),tl.getTeacherCourse(), tl.getVote(), subtotal));
            subtotal += tl.getVote();
        }

    }

    public ArrayListForTeacher<EachTeacherList> getItemList() {
        return itemList;
    }

    public int getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {

        return itemList.toString() + String.format("%-8s","Subtotol = " + subtotal);
    }
}
