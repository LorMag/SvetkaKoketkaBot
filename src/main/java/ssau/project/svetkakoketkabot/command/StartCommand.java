package ssau.project.svetkakoketkabot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.config.ImagesConfig;
import ssau.project.svetkakoketkabot.sender.Sender;

@Component
public class StartCommand {
    @Autowired
    private Sender sender;

    @Autowired
    private ImagesConfig imagesConfig;

    public void commandReceived(Long chatId, String firstName) {
        String message = """
        Привет, %s!
        Меня зовут Светка-Кокетка, я уже кое-чему научилась!
        На данный момент я умею выдавать 5 случайных аниме-тайтлов с помощью команды /anime, 5 случайных фильмов с помощью команды /film, записывать пользователей в список пожеланий командой /wishes и выдавать жаб после набора необрабатываемых букаф.
        """.formatted(firstName);
        sender.sendPhoto(chatId, message, imagesConfig.getStartImage());
    }

}
