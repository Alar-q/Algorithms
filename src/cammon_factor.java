public class cammon_factor {
    //Расчитывает самый большой делитель для расчета соотношения сторон
    public static float common_factor(float width, float height){
        if(width==height)
            return width;
        else{
            float more = Math.max(width, height), less = Math.min(width, height);
            do{
                more -= less;
            }while(more>less);
            return common_factor(more, less);
        }
    }
}
