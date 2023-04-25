package ssau.project.svetkakoketkabot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.entity.User;
import ssau.project.svetkakoketkabot.repository.UserRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

@Component
public class SendCommand {
    @Autowired
    private Sender sender;

    @Autowired
    private UserRepository userRepository;
    public void commandReceived(String text) {

        Iterable<User> users = userRepository.findAll();
        for (User user : users){
            sender.sendMessage(user.getId(), text);
        }


    }
}
