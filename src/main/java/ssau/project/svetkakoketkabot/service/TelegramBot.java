package ssau.project.svetkakoketkabot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ssau.project.svetkakoketkabot.command.*;
import ssau.project.svetkakoketkabot.command.kinopoisk.KinopoiskCommand;
import ssau.project.svetkakoketkabot.command.kinopoisk.MovieType;
import ssau.project.svetkakoketkabot.config.SvetkaConfig;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private SvetkaConfig svetkaConfig;

    @Autowired
    private StartCommand startCommand;

    @Autowired
    private DefaultCommand defaultCommand;

    @Autowired
    private WishCommand wishCommand;

    @Autowired
    private KinopoiskCommand kinopoiskCommand;

    @Autowired
    private SendCommand sendCommand;

    @Override
    public String getBotUsername() {
        return svetkaConfig.getName();
    }

    @Override
    public String getBotToken() {
        return svetkaConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {


            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String name = update.getMessage().getChat().getFirstName();
            String[] commands = messageText.split(" ", 2);

            switch (commands[0]) {
                case "/start" -> startCommand.commandReceived(chatId, name);
                case "/wishes" -> wishCommand.commandReceived(update.getMessage());
                case "/anime" -> kinopoiskCommand.commandReceived(chatId, MovieType.ANIME);
                case "/film" -> kinopoiskCommand.commandReceived(chatId, MovieType.FILM);
                case "/send" -> {
                    if (chatId == 1121192649) {
                        sendCommand.commandReceived(commands[1]);
                    }
                }
                default -> defaultCommand.commandReceived(chatId);
            }

        }
    }

}
