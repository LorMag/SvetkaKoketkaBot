package ssau.project.svetkakoketkabot.command.kinopoisk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ssau.project.svetkakoketkabot.config.ImagesConfig;
import ssau.project.svetkakoketkabot.kinopoisk.Communication;
import ssau.project.svetkakoketkabot.kinopoisk.objects.Movie;
import ssau.project.svetkakoketkabot.sender.Sender;

import java.util.ArrayList;
import java.util.List;

@Component
public class KinopoiskCommand {

    @Autowired
    private Sender sender;
    @Autowired
    private Communication communication;
    @Autowired
    private ImagesConfig imagesConfig;

    public void commandReceived(long chatId, Enum<MovieType> e) {
        if (e == MovieType.ANIME) {
            sendResponse(chatId, communication.getRandomAnimeResponse().getDocs());
        } else sendResponse(chatId, communication.getRandomFilmResponse().getDocs());
    }

    public void sendResponse(long chatId, List<Movie> movies) {
        ArrayList<Integer> indexes = chooseIndexes(new ArrayList<Integer>());
        for (Integer index : indexes){
            Movie tempMovie = movies.get(index);


            if (tempMovie.getName() == null && tempMovie.getAlternativeName() != null){
                tempMovie.setName(tempMovie.getAlternativeName());
            } else if (tempMovie.getName() == null && tempMovie.getAlternativeName() == null){
                tempMovie.setName("Без названия");
            }

            //Добавление постера, если его нет
            if (tempMovie.getPoster() == null){
                tempMovie.addNewPoster(imagesConfig.getNoAnimePhoto());
            }

            //добавление описания
            if (tempMovie.getDescription() == null && tempMovie.getShortDescription() != null){
                tempMovie.setDescription(tempMovie.getShortDescription());
            } else if (tempMovie.getDescription() == null && tempMovie.getShortDescription() == null){
                tempMovie.setDescription("Тайтл почему-то без описания...");
            }

            String text = "<b>Название:</b> " + tempMovie.getName() + "\n" +
                    "<b>Год выхода:</b> " + tempMovie.getYear() + "\n" +
                    "<b>Оценки:</b> " + "\n" +
                    "imdb: " + tempMovie.getRating().getImdb() + "\n" +
                    "Кинопоиск: " + tempMovie.getRating().getKp() + "\n" +
                    "<b>Жанры:</b> " + tempMovie.getGenresString();

            String descriptionText = "<b>Описание:</b> " + tempMovie.getDescription();
            if (text.length() + descriptionText.length() >= 1024){
                sender.sendPhoto(chatId, text, tempMovie.getPoster().getUrl());
                sender.sendMessage(chatId, descriptionText);
            }
             else
                 sender.sendPhoto(chatId, text + "\n" + descriptionText, tempMovie.getPoster().getUrl());
        }
    }
    //подразумеваем, что в полученном листе всегда 10 значений, выбираем 5 случайных
    public ArrayList<Integer> chooseIndexes(ArrayList<Integer> indexes){
        int index;
        while (true){
            index = (int)(Math.random() * 9);
            if (!indexes.contains(index)){
                indexes.add(index);
                if (indexes.size() == 5){
                    break;
                }
            }
        }
        return indexes;
    }
}
