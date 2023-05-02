# 3-part-CleanArchitecture-MultiModule-Mvvm
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm.

> #### * Siz ko'rib turgan projectim clean architecturaning 3-qismi hisoblanadi, authorization uchun simple project qilingan. Ma'lumotlarni saqlash uchun SharedPreferencedan foydalanilgan. Dependency Injection framworklaridan foydalanilmasdan clean architecturaga bosqichma bosqich o'tmoqdaman, va bu qismda mvvm patternni qo'shganman. Proekt claen architectura layerlariga ajratilgan, multi modulga o'tkazilgan va mvvm patterndan foydalanilgan.*

<img width="360" height="480" hspace="20" alt="Screen Shot 2023-05-02 at 15 02 13" src="https://user-images.githubusercontent.com/77477995/235638281-48b4323e-e382-4939-825a-b3659a07428b.png"> <img width="360" height="480" hspace="20" alt="Screen Shot 2023-05-02 at 14 59 02" src="https://user-images.githubusercontent.com/77477995/235638449-e8c96c96-eb9a-40ec-8b4d-2d9fa6863390.png">

ViewModel - bu user interfacening ma'lumotlari va xatti-harakatlarini asosiy data layerdan mustaqil ravishda ishlatish uchun foydalaniladigan design patterndir. ViewModel view va data layer o'rtasida vositachi bo'lib, ikkalasi o'rtasidagi o'zaro ta'sirni soddalashtiradigan qatlam hisoblanadi.

ViewModel odatda viewning ma'lumotlari va xatti-harakatlarini qamrab oluvchi class. Masalan, Android applicationda ViewModel appning ma'lum bir ekrani uchun ma'lumotlarni va logikani o'z ichiga olgan class sifatida ishlatilishi mumkin. ViewModel ma'lumotlarning qanday saqlanishi va boshqarilishini yashirish bilan birga, ma'lumotlarni ko'rsatish va ma'lumotlar bilan ishlashda ekran foydalanishi mumkin bo'lgan xususiyatlar va methodlarni ochib beradi.

ViewModel-dan foydalanishning asosiy afzalliklaridan biri shundaki, u viewning va data layerning concernlarini ajratishga yordam beradi, bu kodni yanada modulli qilish va saqlashni osonlashtiradi.
