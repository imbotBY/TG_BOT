import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "overone_animal_bot";
    }

    @Override
    public String getBotToken() {
        return "5492430016:AAHHcKW3Xs7SeM3jPMGCbbKkfdpMixHiLnk";
    }
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId());

        KeyboardRow keyboard1 = new KeyboardRow();
        keyboard1.add(new KeyboardButton("Dog"));
        keyboard1.add(new KeyboardButton("Cat"));

        KeyboardRow keyboard2 = new KeyboardRow();
        keyboard2.add(new KeyboardButton("Mouse"));
        keyboard2.add(new KeyboardButton("Frog"));
        keyboard2.add(new KeyboardButton("Bird"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboard1);
        list.add(keyboard2);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        switch (update.getMessage().getText())  {
            case "Dog" :
                sendPhoto.setPhoto(new InputFile("https://ichef.bbci.co.uk/news/976/cpsprodpb/17638/production/_124800859_gettyimages-817514614.jpg"));
                break;
            case "Cat" :
                sendPhoto.setPhoto(new InputFile("https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png"));
                break;
            case "Mouse" :
                sendPhoto.setPhoto(new InputFile("https://static4.depositphotos.com/1005805/350/i/600/depositphotos_3504882-stock-photo-gray-mouse.jpg"));
                break;
            case "Frog" :
                sendPhoto.setPhoto(new InputFile("https://www.aquariumofpacific.org/images/exhibits/Magnificent_Tree_Frog_900.jpg"));
                break;
            case "Bird" :
                sendPhoto.setPhoto(new InputFile("https://www.allaboutbirds.org/news/wp-content/uploads/2020/07/STanager-Shapiro-ML.jpg?page=Search"));
                break;
        }

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
