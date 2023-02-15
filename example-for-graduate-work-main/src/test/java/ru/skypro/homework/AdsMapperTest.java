package ru.skypro.homework;

import org.junit.jupiter.api.Test;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.mapper.AdsMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class AdsMapperTest {
    @Test
    public void shouldMapAdsToAdsDto() {
        Ads ads = new Ads();
        ads.setAuthor(1);
        ads.setImage("image.png");
        ads.setPk(111);
        ads.setPrice(222);
        ads.setTitle("Title");

        AdsDto adsDto = AdsMapper.INSTANCE.adsToAdsDto(ads);

        assertThat(adsDto).isNotNull();
        assertThat(adsDto.getAuthor()).isEqualTo(1);
        assertThat(adsDto.getImage()).isEqualTo("image.png");
        assertThat(adsDto.getPk()).isEqualTo(111);
        assertThat(adsDto.getPrice()).isEqualTo(222);
        assertThat(adsDto.getTitle()).isEqualTo("Title");

    }

    @Test
    public void shouldMapAdsDtoToAds() {
        AdsDto adsDto = new AdsDto(1, "image.png", 111, 222, "Title");

        Ads ads = AdsMapper.INSTANCE.adsDtoToAds(adsDto);

        assertThat(ads).isNotNull();
        assertThat(ads.getAuthor()).isEqualTo(1);
        assertThat(ads.getImage()).isEqualTo("image.png");
        assertThat(ads.getPk()).isEqualTo(111);
        assertThat(ads.getPrice()).isEqualTo(222);
        assertThat(ads.getTitle()).isEqualTo("Title");
    }
}