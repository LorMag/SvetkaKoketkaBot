package ssau.project.svetkakoketkabot.scheduler_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.entity.User;
import ssau.project.svetkakoketkabot.repository.MorningPhotoRepository;
import ssau.project.svetkakoketkabot.repository.UserRepository;
import ssau.project.svetkakoketkabot.sender.Sender;

@Component
public class MorningPhotoSchedule {

    private static final String GOOD_MORNING = "ДОБРАВА УТРА!";

    @Autowired
    private MorningPhotoRepository morningPhotoRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Sender sender;

    @Scheduled(cron = "0 0 10 * * *")
    public void send(){

        Long randomPhotoId = choosePhoto();
        String url = morningPhotoRepository.findById(randomPhotoId).orElseThrow().getUrl();
        Iterable<User> users = userRepository.findAll();
        for (User u : users){
            sender.sendPhoto(u.getId(),GOOD_MORNING, url);
        }
    }

    public Long choosePhoto(){
        Long countOfPhotos = morningPhotoRepository.getCountRows();
        return (Long) (long) (1 + (int) (Math.random() * countOfPhotos));
    }

}
