package ssau.project.svetkakoketkabot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.entity.FrogPhoto;
import ssau.project.svetkakoketkabot.repository.FrogPhotoRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

@Component
public class DefaultCommand {

    @Autowired
    private Sender sender;
    @Autowired
    private FrogPhotoRepository frogPhotoRepository;

    public void commandReceived(long chatId){
        String message = "Неизвестная команда. Не расстраивайтесь, попробуйте ещё раз\n";
        FrogPhoto frogPhoto = frogPhotoRepository.findById(choosePhoto()).get();
        message += frogPhoto.getText();
        sender.sendPhoto(chatId, message, frogPhoto.getUrl());
    }

    public Long choosePhoto(){
        Long countOfPhotos = frogPhotoRepository.getCountRows();
        return (Long) (long) (1 + (int) (Math.random() * countOfPhotos));
    }

}
