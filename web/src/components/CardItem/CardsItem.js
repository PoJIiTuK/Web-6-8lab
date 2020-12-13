import React from 'react';
import {CardContainer, FishPhoto, CardInfo, CardTitle, CardDescription, Price, ShopNowBtn} from './CardsItem.styled';

const CardItem = ({shoesPhoto, brand, color, hightfShafl, priceInUAH}) => {
    return (
        <CardContainer>
            <FishPhoto src={shoesPhoto}/>
            <CardInfo>
                <CardTitle>Fish</CardTitle>
                <CardDescription> {brand} {color} fish, length {hightfShafl}. </CardDescription>
                <Price>$ {priceInUAH}</Price>
                <ShopNowBtn>Shop now</ShopNowBtn>
            </CardInfo>
        </CardContainer>
    );
};

export default CardItem;