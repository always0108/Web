package XiyouLinux.data;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("spitterRepository")
public class SpitterRepository {
    private ArrayList<Spitter> spitterRepository = new ArrayList<Spitter>();

    public SpitterRepository(){}

    public ArrayList<Spitter> getSpitterRepository() {
        return spitterRepository;
    }

    public void save(Spitter spitter){
        spitterRepository.add(spitter);
    }

    public Spitter findByUsername(String username){
        for(int i =0;i<spitterRepository.size();i++){
            if(spitterRepository.get(i).getUsername().equals(username))
                return spitterRepository.get(i);
        }
        return new Spitter();
    }
}
