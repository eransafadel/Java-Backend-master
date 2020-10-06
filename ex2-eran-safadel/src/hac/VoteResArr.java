package hac;

import java.util.ArrayList;

/**
 * Class that build array for each cell contains Vote
 */
public class VoteResArr
{
    private static VoteResArr voteResArr;
    private ArrayList<Vote> mList;

    /**
     * singleton function that return the voteResArr
     * @return voteResArr - instance of VoteResArr
     */
    public static VoteResArr getInstance() {
        if(voteResArr== null)
            voteResArr = new VoteResArr();
        return  voteResArr;
    }

    /**
     * Ctor of VoteResArr that build the ArrayList
     */
    public VoteResArr()
    {
        mList = new ArrayList<>();
    }

    /**
     * function that add obj to array
     * @param v - Vote
     */
    public void addIndex(Vote v){mList.add(v);}

    /**
     * function that set count of index from array
     * @param index - from array
     */
    public synchronized void setCountOfIndex(int index ){mList.get(index).setCount(mList.get(index).getCount()+1); }

    /**
     * function that return  count of specific(above) answer
     * @param index - from array
     * @return count - count of specific(above) answer
     */
    public synchronized int getCountByIndex(int index){return mList.get(index).getCount();}

    /**
     *
     * @param index  from array
     * @return answer - specific answer of servey
     */
    public  String getAnswerByIndex(int index){return mList.get(index).getAnswer();}

    /**
     * function that return size of list
     * @return size of list
     */
    public int getSizeList(){return mList.size();}

}