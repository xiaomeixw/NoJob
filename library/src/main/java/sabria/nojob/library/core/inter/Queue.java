package sabria.nojob.library.core.inter;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-07  14:40
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public interface Queue<T> {

    //现在队列中有多少job
    int size();

    //队列中添加一个job
    void add(T job);

    //拿出队列最顶部的job,如果返回Null表示队列为empty
    T peek();

    //移除队列最顶部的job
    void remove();

    //设置监听
    void setListener(Listener<T> listener);


    public interface Listener<T>{
        //添加job的回调
        void onAdd(Queue<T> queue, T job);

        //移除job后的回调
        void onRemove(Queue<T> queue);
    }



}
