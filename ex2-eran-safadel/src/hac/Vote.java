package hac;

/**
 * class the represent Object  Vote ( String answer, Integer count)
 */
public class Vote
{
    /**
     * Ctor of class Vote
     * @param answer-  specific answer of servey
     * @param count count of specific(above) answer
     */
    Vote(String answer, Integer count)
    {
        this.answer = answer;
        this.count = count;
    }

    private Integer count;
    private String answer;

    /**
     * function that return count of specific(above) answer
     * @return count - of specific(above) answer
     */
    public Integer getCount() {
        return count;
    }

    /**
     * function that set count of specific(above) answer
     * @param count -of specific(above) answer
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * function that get specific answer of servey
     * @return specific answer of servey
     */
    public String getAnswer() {
        return answer;
    }

}
