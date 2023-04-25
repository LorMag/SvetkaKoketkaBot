package ssau.project.svetkakoketkabot.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ssau.project.svetkakoketkabot.config.SvetkaConfig;

@Component
public class Sender extends DefaultAbsSender {
    @Autowired
    private SvetkaConfig svetkaConfig;

    @Autowired
    protected Sender(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return svetkaConfig.getToken();
    }

    public void sendMessage(long chatId, String text){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setParseMode(ParseMode.HTML);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendPhoto(long chatId, String text, String photoPath){
        InputFile photo = new InputFile();
        photo.setMedia(photoPath);
        SendPhoto message = new SendPhoto();
        message.setChatId( String.valueOf(chatId));
        message.setPhoto(photo);
        message.setCaption(text);
        message.setParseMode(ParseMode.HTML);
        try{
            execute(message);
        }catch (TelegramApiException e) {
            System.out.println(e.getMessage());
            System.out.println(message.getCaption().length());
        }
    }
}
