package ssau.project.svetkakoketkabot.scheduler_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.entity.User;
import ssau.project.svetkakoketkabot.repository.NightPhotoRepository;
import ssau.project.svetkakoketkabot.repository.UserRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

@Component
public class NightPhotoSchedule {

    //1121192649

    private static final String GOOD_NIGHT = "Спокойновой ночи...";

    @Autowired
    private NightPhotoRepository nightPhotoRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 0 0 * * *")
    public void send(){

        Long randomPhotoId = choosePhoto();
        String url = nightPhotoRepository.findById(randomPhotoId).orElseThrow().getUrl();
        Iterable<User> users = userRepository.findAll();
        for (User u : users){
            sender.sendPhoto(u.getId(),GOOD_NIGHT, url);
        }

    }

    public Long choosePhoto(){
        Long countOfPhotos = nightPhotoRepository.getCountRows();
        return (Long) (long) (1 + (int) (Math.random() * countOfPhotos));
    }

}
