import React, {useState} from 'react';
import CatalogCardItem from '../../components/CatalogCardItem/CatalogCardItem';
import { CatalogOuter, Input, IconMore, Forms, Cards, SearchBtn, SearchForm, InputSearch, FilterForm, NewFunctions, InputFilterForms, ByPrice, ByLength, FormHead, MinPrice, MaxLength, MaxPrice, MinLength, ApplyBtn } from '../Catalog/Catalog.styled';
import blueFish from "./../../icons/catalog/blue_fish.jpg";
import goldFish from "./../../icons/catalog/gold_fish.jpg";
import blackWhiteFish from "./../../icons/catalog/black-white.jpg";
import yellowFish from "./../../icons/catalog/yellow_fish.jpg";
import emmoFish from "./../../icons/catalog/emmo.jpg";
import blackFish from "./../../icons/catalog/black_fish.jpg";
import more from "./../../icons/catalog/more-filter.png";

const data = [
    {
        shoesPhoto: goldFish,
        color: 'gold',
        priceInUAH: 600,
        lengthShafl: 24.5,
    },
    {
        shoesPhoto: blueFish,
        color: 'blue',
        priceInUAH: 500,
        lengthShafl: 11,
    },
    {
        shoesPhoto: blackWhiteFish,
        color: 'black-white',
        priceInUAH: 150,
        lengthShafl: 6.5,
    },
    {
        shoesPhoto: yellowFish,
        color: 'yellow',
        priceInUAH: 350,
        lengthShafl: 6.5,
    },
    {
        shoesPhoto: emmoFish,
        color: 'emmo',
        priceInUAH: 300,
        lengthShafl: 5.5,
    },
    {
        shoesPhoto: blackFish,
        color: 'black',
        priceInUAH: 400,
        lengthShafl: 5,
    },
];

const Catalog = () => {
    const [checkFiltr, setCheckFilter] = useState(false);
    const [itemsToShow, setItemsToShow] = useState(data);
    const [title, setTitle] = useState('');
    const [minPrice, setMinPrice] = useState('20');
    const [maxPrice, setMaxPrice] = useState('400');
    const [minLength, setMinLength] = useState('4');
    const [maxLength, setMaxLength] = useState('15');

    const search = (input) => {
        setItemsToShow(itemsToShow.filter((item) => ( item.color.toLowerCase().includes(input)) ));
    };

    const filter = (minPrice, maxPrice, minLength, maxLength) => {
        setItemsToShow(itemsToShow.filter((item) => ((item.priceInUAH >= parseInt(minPrice)) && (item.priceInUAH <= parseInt(maxPrice)) && (item.lengthShafl >= parseInt(minLength)) && (item.lengthShafl <= (maxLength))) ));
    }

    return(
        <CatalogOuter>
            <Forms>
                <FilterForm>
                    <FormHead>
                        <h3>Filer by: </h3>
                        <Input type="checkbox" id="check" onChange={() => setCheckFilter(!checkFiltr)}></Input>
                        <label for="check">
                            <i><IconMore src={more} check={checkFiltr}/></i>
                        </label>
                    </FormHead>
                   
                    <NewFunctions check={checkFiltr}>
                    { checkFiltr&&
                    <InputFilterForms> 
                        <h4>Price: </h4> 
                        <ByPrice>
                            <MinPrice type="text" placeholder="min price" defaultValue = "20" onChange={event => setMinPrice(event.target.value)}/> <br/>
                            <MaxPrice type="text" placeholder="max price" defaultValue = "5000" onChange={event => setMaxPrice(event.target.value)}/> <br/>
                        </ByPrice>   
                        <h4>Length: </h4>
                        <ByLength>
                            <MinLength type="text" placeholder="min Length" defaultValue = "2" onChange={event => setMinLength(event.target.value)}/> <br/>
                            <MaxLength type="text" placeholder="max Length" defaultValue = "27" onChange={event => setMaxLength(event.target.value)}/> <br/>
                        </ByLength> 
                        <ApplyBtn type="button" onClick={() => filter(minPrice, maxPrice, minLength, maxLength)}>Apply</ApplyBtn>
                    </InputFilterForms>
                    }
                    </NewFunctions>length
                    
                </FilterForm>
                <SearchForm>
                    <InputSearch type="text" id="input" placeholder="Search by color" value={title} onChange={event => setTitle(event.target.value)} /> <br/>
                    <SearchBtn onClick={() => search(title)}></SearchBtn>
                </SearchForm>
            </Forms>
            <Cards>
                {itemsToShow.map(({shoesPhoto, color, priceInUAH, lengthShafl, materialOfVamp, toecapType, id}, idx) => (
                    <CatalogCardItem
                        shoesPhoto={shoesPhoto}
                        color={color}
                        priceInUAH={priceInUAH}
                        lengthShafl={lengthShafl}
                        materialOfVamp={materialOfVamp}
                        toecapType={toecapType}
                        id={id}
                        key={idx}
                    />
                ))}
            </Cards>
        </CatalogOuter>
    );
};

export default Catalog;