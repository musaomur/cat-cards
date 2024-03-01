package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable int id) {
        CatCard card = catCardDao.getCatCardById(id);
        return card;
    }

    //@RequestMapping(path = "/random", method = RequestMethod.GET)
    @GetMapping("random")
    public CatCard newRandom() {
        CatCard card = new CatCard();
        card.setCatFact(catFactService.getFact().getText());
        card.setImgUrl(catPicService.getPic().getFile());

        return card;
    }

    @GetMapping
    public List<CatCard> allCards() {
        List<CatCard> cardList = new ArrayList<>();
        cardList = catCardDao.getCatCards();
        return cardList;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCardToCollection(@RequestBody CatCard catCard) {
        catCardDao.createCatCard(catCard);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCard(@RequestBody CatCard catCard, @PathVariable int id) {
        catCard.setCatCardId(id);
        catCardDao.updateCatCard(catCard);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable int id) {
        catCardDao.deleteCatCardById(id);
    }

}
