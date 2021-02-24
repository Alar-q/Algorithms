package framework;

public class common_factor {
    //Расчитывает самый большой делитель для расчета соотношения сторон
    public float common_factor(float width, float height){
        if(width==height || width==0 || height==0)
            return width;
        else{
            float more = Math.max(width, height), less = Math.min(width, height);

            /*
             do{
                more -= less;
            }while(more>less);
            */

            float dif = more - less;
            int times = (int) Math.ceil( dif / less );

            more -= times * less;

            return common_factor(more, less);
        }
    }
}
