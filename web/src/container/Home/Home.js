
import React, {useState, useEffect} from 'react';
import {Advertisment, AdvertismentTitle, AdvertismentText, ShowMoreBtn, MostPopular, MostPopularTitle, Cards, HomePage} from './Home.styled'
import {ReactComponent as Line } from "./../../icons/most-popular/line.svg";
import fish1 from "./../../icons/most-popular/cards/fish1.png";
import fish2 from "./../../icons/most-popular/cards/fish2.png";
import CardItem from './../../components/CardItem/CardsItem'
const data = [
    {
        shoesPhoto: fish1,
        color: 'yellow',
        priceInUAH: 200,
        hightfShafl: '20см',
    },
    {
        shoesPhoto: fish2,
        color: 'all',
        priceInUAH: 300,
        hightfShafl: '20см',
    },
];
const Home = () => { 
    const [itemsToShow, setItemsToShow] = useState(data.slice(0, 2));
    const [isViewMore, setIsViewMore] = useState(false);

    const showMore = () => {
        setItemsToShow(data);
        setIsViewMore(true);
      };

    const showLess = () => {
        setItemsToShow(data.slice(0, 2));
        setIsViewMore(false);
    };
    return(
        <HomePage>
            <Advertisment>
                <AdvertismentTitle>Admire Stylish Dresses & Looks </AdvertismentTitle>
                <AdvertismentText>If we wanted to build a human-level tool to offer automated outfit advice, we needed to understand people’s fashion taste. </AdvertismentText>
                <ShowMoreBtn>Show more</ShowMoreBtn>
            </Advertisment>
            <MostPopular>
                <MostPopularTitle>
                    <Line/>
                    <p>The MOST popular this season</p>
                    <Line/>
                </MostPopularTitle>
                <Cards>
                    {itemsToShow.map(({shoesPhoto, color, priceInUAH, lengthShafl }, idx) => (
                        <CardItem
                            shoesPhoto={shoesPhoto}
                            color={color}
                            priceInUAH={priceInUAH}
                            lengthShafl={lengthShafl}
                            id={idx}
                        />
                    ))}
                </Cards>
                {!isViewMore && (<ViewMoreBtn onClick={() => showMore()}>View more</ViewMoreBtn>)}
                {isViewMore && (<ViewMoreBtn onClick={() => showLess()}>View less</ViewMoreBtn>)}
            </MostPopular>
        </HomePage>);
};

export default Home;
