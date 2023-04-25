package ssau.project.svetkakoketkabot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ssau.project.svetkakoketkabot.entity.User;
import ssau.project.svetkakoketkabot.repository.UserRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WishCommand {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    public void commandReceived(Message message){
        if (userRepository.findById(message.getChatId()).isEmpty()){
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date));
            userRepository.save(new User(message.getChatId(), message.getChat().getFirstName(),
                    message.getChat().getFirstName(), formatter.format(date)));
            String text = "Вы успешно подписались на рассылку утренних и вечерних сообщений :)";
            sender.sendMessage(message.getChatId(), text);
        } else {
            String text = "К счастью, вы и так подписаны! :)";
            sender.sendMessage(message.getChatId(), text);
        }
    }

}
