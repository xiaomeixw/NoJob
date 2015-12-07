package sabria.nojob.library.core;

import sabria.nojob.library.core.inter.Job;
import sabria.nojob.library.core.inter.JobInjector;
import sabria.nojob.library.core.inter.Queue;

/**
 * Created by xiongwei,An Android project Engineer.
 * Date:2015-12-07  14:51
 * Base on Meilimei.com (PHP Service)
 * Describe:
 * Version:1.0
 * Open source
 */
public class JobQueue<T extends Job> implements Queue<T> {

    private final JobInjector<T> jobInjector;
    private final Queue<T> delegate;


    JobQueue(Queue<T> delegate){
        this(delegate,null);
    }

    public JobQueue(Queue<T> delegate, JobInjector<T> jobInjector) {
        this.delegate = delegate;
        this.jobInjector = jobInjector;
    }

    /**
     * 具体Queue去做业务逻辑
     * @return
     */
    @Override
    public int size() {

        return delegate.size();
    }

    @Override
    public void add(T job) {
        delegate.add(job);
    }

    @Override
    public T peek() {
        T job = delegate.peek();
        if(job!=null && jobInjector !=null){
            jobInjector.injectMembers(job);
        }
        return job;
    }

    @Override
    public void remove() {
        delegate.remove();
    }

    @Override
    public void setListener(final Listener<T> listener) {
        if(listener!=null){
        delegate.setListener(new Listener<T>() {
            @Override
            public void onAdd(Queue<T> queue, T job) {
                listener.onAdd(JobQueue.this,job);
            }

            @Override
            public void onRemove(Queue<T> queue) {
                listener.onRemove(JobQueue.this);
            }
        });
        }else{
            delegate.setListener(null);
        }


    }
}
