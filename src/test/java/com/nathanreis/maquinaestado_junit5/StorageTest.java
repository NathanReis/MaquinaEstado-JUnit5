package com.nathanreis.maquinaestado_junit5;

import com.nathanreis.maquinaestado_junit5.model.AnimeModel;
import com.nathanreis.maquinaestado_junit5.storage.Storage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    @DisplayName("Test if singleton is working")
    public void testInstance() {
        Storage storage = Storage.getInstance();
        
        String classExpect = "Storage";
        
        assertNotNull(storage);
        assertEquals(classExpect, storage.getClass().getSimpleName());
    }
    
    @Test
    @DisplayName("Test if is saving")
    public void testSave() {
        assertNull(Storage.getInstance().getAnime());
        
        String name = "Death Note";
        int amountTotalEpisodes = 37;
        int amountSeasons = 1;
        
        AnimeModel anime = new AnimeModel();
        anime.setName(name);
        anime.setAmountTotalEpisodes(amountTotalEpisodes);
        anime.setAmountSeasons(amountSeasons);
        
        Storage.getInstance().save(anime);
        
        assertNotNull(Storage.getInstance().getAnime());
        assertEquals(name, Storage.getInstance().getAnime().getName());
        assertEquals(amountTotalEpisodes, Storage.getInstance().getAnime().getAmountTotalEpisodes());
        assertEquals(amountSeasons, Storage.getInstance().getAnime().getAmountSeasons());
    }
    
    @Test
    @DisplayName("Test if is deleting")
    public void testDelete() {
        AnimeModel anime = new AnimeModel();
        anime.setName("Death Note");
        anime.setAmountTotalEpisodes(37);
        anime.setAmountSeasons(1);
        
        Storage.getInstance().save(anime);
        
        assertNotNull(Storage.getInstance().getAnime());
        
        Storage.getInstance().delete();
        
        assertNull(Storage.getInstance().getAnime());
    }
}
