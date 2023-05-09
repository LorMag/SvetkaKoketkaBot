package ssau.project.svetkakoketkabot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.entity.User;
import ssau.project.svetkakoketkabot.repository.UserRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

import java.util.List;

@Component
public class SendCommand {
    @Autowired
    private Sender sender;

    @Autowired
    private UserRepository userRepository;
    public void commandReceived(String text) {

        List<User> users = userRepository.findAll();
        users.parallelStream().forEach(user -> sender.sendMessage(user.getId(), text));
    }
}
