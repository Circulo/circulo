import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import play.Application;
import play.GlobalSettings;

/**
 * Created by tfulton on 5/23/15.
 */
public class Global
        extends GlobalSettings {

        protected ApplicationContext ctx;

        @Override
        public void onStart(Application application) {
                super.onStart(application);
//                ctx = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
                ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        }

        @Override
        public <A> A getControllerInstance(Class<A> clazz)
        {
                return ctx.getBean(clazz);
        }

        @Override
        public void onStop(Application application) {
                super.onStop(application);
        }
}
