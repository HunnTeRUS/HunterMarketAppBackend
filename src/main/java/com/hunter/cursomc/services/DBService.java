package com.hunter.cursomc.services;

import com.hunter.cursomc.domain.*;
import com.hunter.cursomc.domain.enums.EstadoPagamento;
import com.hunter.cursomc.domain.enums.Perfil;
import com.hunter.cursomc.domain.enums.TipoCliente;
import com.hunter.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    InitializeCityesAndStates initializeCityesAndStates;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItensPedidoRepository itensPedidoRepository;

    @Autowired
    BCryptPasswordEncoder pe;

    public void instantiateTestDatabase() throws ParseException {
        Categoria cat1 = new Categoria(null, "Informatica"      );
        Categoria cat2 = new Categoria(null, "Escritorio"       );
        Categoria cat3 = new Categoria(null, "Cama/Mesa/Banho"  );
        Categoria cat4 = new Categoria(null, "Cozinha"          );
        Categoria cat5 = new Categoria(null, "Banheiro"         );
        Categoria cat6 = new Categoria(null, "Quintal"          );
        Categoria cat7 = new Categoria(null, "Empresa"          );
        Categoria cat8 = new Categoria(null, "Gamer"            );

        Produto p1 = new Produto(null, "Monitor Fullscreen - AOC", 700.00, 1);
        Produto p2 = new Produto(null, "Nootbook - Samsung", 4000.00, 2);

        Produto p3 = new Produto(null, "Mesa de Escritório", 350.00, 3);
        Produto p4 = new Produto(null, "Organizador de Arquivos", 50.00, 4);

        Produto p5 = new Produto(null, "Colcha", 200.00, 5);
        Produto p6 = new Produto(null, "Shampoo", 10.00, 6);
        Produto p7 = new Produto(null, "Toalha de Rosto", 25.00, 7);

        Produto p8 = new Produto(null, "Mesa de Cozinha", 300.00, 8);
        Produto p9 = new Produto(null, "Liquidificador", 10.0, 9);
        Produto p10 = new Produto(null, "Microondas", 10.00, 10);
        Produto p11 = new Produto(null, "Armario Planejado", 10.00, 11);

        Produto p12 = new Produto(null, "Gabinete com Pia", 200.00, 12);
        Produto p13= new Produto(null, "Chuveiro", 120.00, 13);
        Produto p14 = new Produto(null, "Tapete Antiderrapante", 30.00, 14);
        Produto p15 = new Produto(null, "Saboneteira", 15.00, 15);

        Produto p16 = new Produto(null, "Piscina", 900.00, 16);
        Produto p17 = new Produto(null, "Jardim Vertical", 100.00, 17);
        Produto p18 = new Produto(null, "Churrasqueira", 200.00, 18);
        Produto p19 = new Produto(null, "Parafusadeira", 100.00, 19);

        Produto p20 = new Produto(null, "Impressora Laser - HP", 2000.00, 20);
        Produto p21 = new Produto(null, "Pacote folhas Sufite - Report", 40.00, 21);
        Produto p22 = new Produto(null, "Mesa Digitalizadora", 110.99, 22);
        Produto p23 = new Produto(null, "Armario Porta Celular", 300.00, 23);

        Produto p24 = new Produto(null, "Monitor Ultrawide", 800.00, 24);
        Produto p25 = new Produto(null, "Cadeira DXRacer", 1000.00, 25);
        Produto p26 = new Produto(null, "MousePad Redragon", 120.50, 26);
        Produto p27 = new Produto(null, "Fone Razer", 400.00, 27);
        Produto p28 = new Produto(null, "Computador Gamer", 3500.00, 28);
        Produto p29 = new Produto(null, "Mouse sem fio Razer", 500.00, 29);
        Produto p30 = new Produto(null, "SSD 1TB Samsung", 1100.00, 30);
        Produto p31 = new Produto(null, "Placa Mãe Asus Prime", 600.00, 31);
        Produto p32 = new Produto(null, "Fonte 700w EVGA", 400.00, 32);

        Produto p33 = new Produto(null, "Processador AMD Ryzen 5 2600", 899.90, 33);
        Produto p34 = new Produto(null, "Memoria XPG Gammix D30", 289.90, 34);
        Produto p35 = new Produto(null, "Headset Gamer Logitech G935", 800.00, 35);
        Produto p36 = new Produto(null, "SSD Crucial BX500 480GB", 509.00, 36);
        Produto p37 = new Produto(null, "Monitor Gamer AOC HERO W-LED 23.8", 1799.00, 37);
        Produto p38 = new Produto(null, "Console Microsoft Xbox One S 1TB", 2000.00, 38);
        Produto p39 = new Produto(null, "Cadeira Gamer Husky Blizzard", 1359.00, 39);
        Produto p40 = new Produto(null, "Headset Gamer HyperX Cloud", 759.00, 40);
        Produto p41 = new Produto(null, "Monitor Gamer Acer LED 24'", 779.00, 41);
        Produto p42 = new Produto(null, "Teclado Mecânico Gamer HyperX Alloy", 749.00, 42);
        Produto p43 = new Produto(null, "Headset sem fio Gamer HyperX", 899.00, 43);
        Produto p44 = new Produto(null, "Mouse Gamer HyperX Pulsefire RGB", 249.90, 44);
        Produto p45 = new Produto(null, "Processador Intel Core i7 9700KF", 2299.90, 45);
        Produto p46 = new Produto(null, "Notebook Asus AMD Ryzen 5 3500U", 3399.00, 46);
        Produto p47 = new Produto(null, "Nobreak SMS 600va", 359.90, 47);
        Produto p48 = new Produto(null, "Gabinete NOX HUMMER FUSION", 439.00, 48);
        Produto p49 = new Produto(null, "AirPods com Estojo de Recarga", 1200.00, 49);
        Produto p50 = new Produto(null, "Mouse Gamer Logitech G403 Hero 16k", 199.00, 50);
        Produto p51 = new Produto(null, "MacBook Air Apple Intel COre i5", 7599.00, 51);
        Produto p52 = new Produto(null, "Teclado Mecanico Gamer Razer BlackWindow", 400.00, 52);

        Produto p53 = new Produto(null, "Multifuncional Brother Laser", 1999.00, 53);
        Produto p54 = new Produto(null, "Amazon Smart Home EchoShow5 ALexa", 469.00, 54);
        Produto p55 = new Produto(null, "Access Point TP-Link Wireless Dual Band", 752.82, 55);
        Produto p56 = new Produto(null, "Access Point TP-Link Wireless N300", 192.82, 56);
        Produto p57 = new Produto(null, "Calculadora Cientifica CASIO", 49.00, 57);
        Produto p58 = new Produto(null, "Calculadora Eletrônica Hoopson", 11.90, 58);
        Produto p59 = new Produto(null, "Impressora Térmica Epson", 518.90, 59);
        Produto p60 = new Produto(null, "Impressora de Cheques Menno", 1487.00, 60);
        Produto p61 = new Produto(null, "Relogio de Ponto Gertec", 1669.90, 61);
        Produto p62 = new Produto(null, "Repetidor Powerline D-Link", 302.90, 62);

        Produto p63 = new Produto(null, "Toalha de risti Felpuda", 5.61, 63);
        Produto p64 = new Produto(null, "Edredom Liverpool casal", 2003.90, 64);
        Produto p65 = new Produto(null, "Travesseiro Percal 200 fios", 23.90, 65);
        Produto p66 = new Produto(null, "Jogo de Cama Malha Stampa King", 202.90, 66);
        Produto p67 = new Produto(null, "Kit Cobreleito 200 fios queen", 284.05, 67);
        Produto p68 = new Produto(null, "Cobreleito 180 fios King Size", 229.05, 68);
        Produto p69 = new Produto(null, "Kit cobreleito Total Mix 150 fios", 217.05, 69);
        Produto p70 = new Produto(null, "Cobreleito 200 fios Queen Florance", 483.05, 70);
        Produto p71 = new Produto(null, "Kit Cobreleito Malha Stampa", 239.05, 71);
        Produto p72 = new Produto(null, "Kit Cobreleito Platinum 200", 197.05, 72);
        Produto p73 = new Produto(null, "Toalha de Mesa Celebration", 89.32, 73);
        Produto p74 = new Produto(null, "Toalha de Mesa Retangular Patreon", 64.21, 74);
        Produto p75 = new Produto(null, "Toalha de Mesa Celebration Verissimo", 81.05, 75);
        Produto p76 = new Produto(null, "Toalha de Mesa Celebration Quadrada", 284.05, 76);
        Produto p77 = new Produto(null, "Toalha de Mesa Venturini", 88.23, 77);
        Produto p78 = new Produto(null, "Toalha de Rosto Paris", 8.60, 78);
        Produto p79 = new Produto(null, "Toalha de Rosto Felpuda Lumiere", 14.05, 79);
        Produto p80 = new Produto(null, "Toalha de Banho Provence", 25.05, 80);
        Produto p81 = new Produto(null, "Toalha de Banho Felpuda Escala", 12.35, 81);
        Produto p82 = new Produto(null, "Toalha de Rosto Empire", 10.05, 82);

        Produto p83 = new Produto(null, "Micro-ondas Electrolux 34 litros", 499.05, 83);
        Produto p84 = new Produto(null, "Refrigerador ELectrolux", 2000.05, 84);
        Produto p85 = new Produto(null, "Fogão 4 bocas Automatico Star Atiaia", 489.90, 85);
        Produto p86 = new Produto(null, "Cooktop 5 bocas Braslar", 599.05, 86);
        Produto p87 = new Produto(null, "Forno Eletrico Inox Amvox", 799.90, 87);
        Produto p88 = new Produto(null, "Frigobar Philco", 519.90, 88);
        Produto p89 = new Produto(null, "Armario Aereo 1200mm", 313.90, 89);
        Produto p90 = new Produto(null, "Balcão Sicília", 512.90, 90);
        Produto p91 = new Produto(null, "Forno de Pizza a lenha", 835.90, 91);
        Produto p92 = new Produto(null, "Cervejeira 110v", 4939.90, 92);

        Produto p93  = new Produto(null, "Balcão para banheiro Politorno", 166.90, 93);
        Produto p94  = new Produto(null, "Balcão para banheiro SUspenso", 383.80, 94);
        Produto p95  = new Produto(null, "Conjunto para banheiro Cuba Vix", 233.70, 95);
        Produto p96  = new Produto(null, "Balcão para banheiro com 1 porta Lagos", 328.90, 96);
        Produto p97  = new Produto(null, "Conjunto para banheiro com 1 porta e cuba", 121.90, 97);
        Produto p98  = new Produto(null, "Balcão para banheiro suspenso", 367.54, 98);
        Produto p99  = new Produto(null, "Espelho para Banheiro Treviso", 129.20, 99);
        Produto p100 = new Produto(null, "Espelheira para banheiro MGM", 115.10, 100);

        Produto p101 = new Produto(null, "Churrasqueira Elétrica Cotherm", 72.10, 101);
        Produto p102 = new Produto(null, "Churrasqueira Elétrica Jobs Grill", 499.10, 102);;
        Produto p103 = new Produto(null, "Jardim Suspenso Josi Flores", 300.10, 103);
        Produto p104 = new Produto(null, "Piscina 1500l infantil", 119.10, 104);
        Produto p105 = new Produto(null, "Piscina infantil 2000l", 229.99, 105);


        p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat2, cat7));
        p4.getCategorias().addAll(Arrays.asList(cat2, cat7));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat3));
        p8.getCategorias().addAll(Arrays.asList(cat4));
        p9.getCategorias().addAll(Arrays.asList(cat4));
        p10.getCategorias().addAll(Arrays.asList(cat4));
        p11.getCategorias().addAll(Arrays.asList(cat4));
        p12.getCategorias().add(cat5);
        p13.getCategorias().add(cat5);
        p14.getCategorias().add(cat5);
        p15.getCategorias().add(cat5);
        p16.getCategorias().add(cat6);
        p17.getCategorias().add(cat6);
        p18.getCategorias().add(cat6);
        p19.getCategorias().add(cat6);
        p20.getCategorias().addAll(Arrays.asList(cat1,cat7));
        p21.getCategorias().addAll(Arrays.asList(cat2,cat7));
        p22.getCategorias().addAll(Arrays.asList(cat2,cat7));
        p23.getCategorias().addAll(Arrays.asList(cat2,cat7));
        p24.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p25.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p26.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p27.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p28.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p29.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p30.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p31.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p32.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p33.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p34.getCategorias().addAll(Arrays.asList(cat1));
        p35.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p36.getCategorias().addAll(Arrays.asList(cat1,cat7));
        p37.getCategorias().addAll(Arrays.asList(cat1));
        p38.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p39.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p40.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p41.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p43.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p44.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p45.getCategorias().addAll(Arrays.asList(cat1));
        p46.getCategorias().addAll(Arrays.asList(cat1));
        p47.getCategorias().addAll(Arrays.asList(cat1, cat7));
        p48.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p49.getCategorias().addAll(Arrays.asList(cat1));
        p50.getCategorias().addAll(Arrays.asList(cat1, cat8));
        p51.getCategorias().addAll(Arrays.asList(cat1, cat7));
        p52.getCategorias().addAll(Arrays.asList(cat1, cat8));

        p53.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));
        p54.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));
        p55.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));
        p56.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));
        p57.getCategorias().addAll(Arrays.asList(cat2, cat7));
        p58.getCategorias().addAll(Arrays.asList(cat2, cat7));
        p59.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));
        p61.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p62.getCategorias().addAll(Arrays.asList(cat1, cat2, cat7));

        p63.getCategorias().addAll(Arrays.asList(cat3));
        p64.getCategorias().addAll(Arrays.asList(cat3));
        p65.getCategorias().addAll(Arrays.asList(cat3));
        p66.getCategorias().addAll(Arrays.asList(cat3));
        p67.getCategorias().addAll(Arrays.asList(cat3));
        p68.getCategorias().addAll(Arrays.asList(cat3));
        p69.getCategorias().addAll(Arrays.asList(cat3));
        p70.getCategorias().addAll(Arrays.asList(cat3));
        p71.getCategorias().addAll(Arrays.asList(cat3));
        p72.getCategorias().addAll(Arrays.asList(cat3));
        p73.getCategorias().addAll(Arrays.asList(cat3));
        p74.getCategorias().addAll(Arrays.asList(cat3));
        p75.getCategorias().addAll(Arrays.asList(cat3));
        p76.getCategorias().addAll(Arrays.asList(cat3));
        p77.getCategorias().addAll(Arrays.asList(cat3));
        p78.getCategorias().addAll(Arrays.asList(cat3));
        p79.getCategorias().addAll(Arrays.asList(cat3));
        p80.getCategorias().addAll(Arrays.asList(cat3));
        p81.getCategorias().addAll(Arrays.asList(cat3));
        p82.getCategorias().addAll(Arrays.asList(cat3));

        p83.getCategorias().addAll(Arrays.asList(cat4));
        p84.getCategorias().addAll(Arrays.asList(cat4));
        p85.getCategorias().addAll(Arrays.asList(cat4));
        p86.getCategorias().addAll(Arrays.asList(cat4));
        p87.getCategorias().addAll(Arrays.asList(cat4));
        p88.getCategorias().addAll(Arrays.asList(cat4));
        p89.getCategorias().addAll(Arrays.asList(cat4));
        p90.getCategorias().addAll(Arrays.asList(cat4));
        p91.getCategorias().addAll(Arrays.asList(cat4));
        p92.getCategorias().addAll(Arrays.asList(cat4));

        p93.getCategorias().addAll(Arrays.asList(cat5));
        p94.getCategorias().addAll(Arrays.asList(cat5));
        p95.getCategorias().addAll(Arrays.asList(cat5));
        p96.getCategorias().addAll(Arrays.asList(cat5));
        p97.getCategorias().addAll(Arrays.asList(cat5));
        p98.getCategorias().addAll(Arrays.asList(cat5));
        p99.getCategorias().addAll(Arrays.asList(cat5));
        p100.getCategorias().addAll(Arrays.asList(cat5));
        p101.getCategorias().addAll(Arrays.asList(cat6));
        p102.getCategorias().addAll(Arrays.asList(cat6));
        p103.getCategorias().addAll(Arrays.asList(cat6));
        p104.getCategorias().addAll(Arrays.asList(cat6));
        p105.getCategorias().addAll(Arrays.asList(cat6));

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p20,p24,p25,p26,p27,p28,p29,p30,p31,p32, p33,p34,
                p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p59,p60,p62));

        cat2.getProdutos().addAll(Arrays.asList(p2, p3,p4, p21,p22,p23, p53,p54,p55,p56,p57,p58,p59,p60,p61,p62));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6, p7,p47, p51, p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76,p77,p78,p79,p80,p81,p82));
        cat4.getProdutos().addAll(Arrays.asList(p8, p9,p10, p11, p83,p84,p85,p86,p87,p88,p89,p90,p91,p92));
        cat5.getProdutos().addAll(Arrays.asList(p12, p13,p14, p15, p93, p94, p95, p96, p97, p98, p99, p100));
        cat6.getProdutos().addAll(Arrays.asList(p16, p17,p18, p19, p101,p102,p103,p104,p105));
        cat7.getProdutos().addAll(Arrays.asList(p20, p21,p22, p23,p36,p47,p51,p53,p54,p55,p56,p57,p58,p59,p62));
        cat8.getProdutos().addAll(Arrays.asList(p24, p25,p26, p27,p28,p29,p30,p31,p32,p33,
                p35,p38,p39,p40,p41,p42,p43,p44,p48,p50,p52));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14,
                p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33,
                p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52, p53,p54,p55,p56,p57,
                p58,p59,p60,p61,p62, p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76,p77,p78,p79,p80,p81,p82,
                p83,p84,p85,p86,p87,p88,p89,p90,p91,p92, p93,p94,p95,p96,p97,p98,p99,p100, p101,p102,p103,p104,p105));

        Estado est1 = new Estado(null, "Acre");
        Estado est2 = new Estado(null, "Alagoas");
        Estado est3 = new Estado(null, "Amapá");
        Estado est4 = new Estado(null, "Amazonas");
        Estado est5 = new Estado(null, "Bahia");
        Estado est6 = new Estado(null, "Ceará");
        Estado est7 = new Estado(null, "Distrito Federal*");
        Estado est8 = new Estado(null, "Espírito Santo");
        Estado est9 = new Estado(null, "Goiás");
        Estado est10 = new Estado(null, "Maranhão");
        Estado est11 = new Estado(null, "Mato Grosso");
        Estado est12 = new Estado(null, "Mato Grosso do Sul");
        Estado est13 = new Estado(null, "Minas Gerais");
        Estado est14 = new Estado(null, "Pará");
        Estado est15 = new Estado(null, "Paraíba");
        Estado est16 = new Estado(null, "Paraná");
        Estado est17 = new Estado(null, "Pernambuco");
        Estado est18 = new Estado(null, "Piauí");
        Estado est19 = new Estado(null, "Rio de Janeiro");
        Estado est20 = new Estado(null, "Rio Grande do Norte");
        Estado est21 = new Estado(null, "Rio Grande do Sul");
        Estado est22 = new Estado(null, "Rondônia");
        Estado est23 = new Estado(null, "Roraima");
        Estado est24 = new Estado(null, "Santa Catarina");
        Estado est25 = new Estado(null, "Sao Paulo");
        Estado est26 = new Estado(null, "Sergipe");
        Estado est27 = new Estado(null, "Tocantins");

        List<Cidade> listaAC = initializeCityesAndStates.getCidadesAC(est1);
        List<Cidade> listaAL = initializeCityesAndStates.getCidadesAL(est2);
        List<Cidade> listaAP = initializeCityesAndStates.getCidadesAP(est3);
        List<Cidade> listaAM = initializeCityesAndStates.getCidadesAM(est4);
        List<Cidade> listaBA = initializeCityesAndStates.getCidadesBA(est5);
        List<Cidade> listaCE = initializeCityesAndStates.getCidadesCE(est6);
        List<Cidade> listaDF = initializeCityesAndStates.getCidadesDF(est7);
        List<Cidade> listaES = initializeCityesAndStates.getCidadesES(est8);
        List<Cidade> listaGO = initializeCityesAndStates.getCidadesGO(est9);
        List<Cidade> listaMA = initializeCityesAndStates.getCidadesMA(est10);
        List<Cidade> listaMT = initializeCityesAndStates.getCidadesMT(est11);
        List<Cidade> listaMS = initializeCityesAndStates.getCidadesMS(est12);
        List<Cidade> listaMG = initializeCityesAndStates.getCidadesMG(est13);
        List<Cidade> listaPA = initializeCityesAndStates.getCidadesPA(est14);
        List<Cidade> listaPB = initializeCityesAndStates.getCidadesPB(est15);
        List<Cidade> listaPR = initializeCityesAndStates.getCidadesPR(est16);
        List<Cidade> listaPE = initializeCityesAndStates.getCidadesPE(est17);
        List<Cidade> listaPI = initializeCityesAndStates.getCidadesPI(est18);
        List<Cidade> listaRJ = initializeCityesAndStates.getCidadesRJ(est19);
        List<Cidade> listaRN = initializeCityesAndStates.getCidadesRN(est20);
        List<Cidade> listaRS = initializeCityesAndStates.getCidadesRS(est21);
        List<Cidade> listaRO = initializeCityesAndStates.getCidadesRO(est22);
        List<Cidade> listaRR = initializeCityesAndStates.getCidadesRR(est23);
        List<Cidade> listaSC = initializeCityesAndStates.getCidadesSC(est24);
        List<Cidade> listaSP = initializeCityesAndStates.getCidadesSP(est25);
        List<Cidade> listaSE = initializeCityesAndStates.getCidadesSE(est26);
        List<Cidade> listaTO = initializeCityesAndStates.getCidadesTO(est27);

        est1.getCidades().addAll(listaAC);
        est2.getCidades().addAll(listaAL);
        est3.getCidades().addAll(listaAP);
        est4.getCidades().addAll(listaAM);
        est5.getCidades().addAll(listaBA);
        est6.getCidades().addAll(listaCE);
        est7.getCidades().addAll(listaDF);
        est8.getCidades().addAll(listaES);
        est9.getCidades().addAll(listaGO);
        est10.getCidades().addAll(listaMA);
        est11.getCidades().addAll(listaMT);
        est12.getCidades().addAll(listaMS);
        est13.getCidades().addAll(listaMG);
        est14.getCidades().addAll(listaPA);
        est15.getCidades().addAll(listaPB);
        est16.getCidades().addAll(listaPR);
        est17.getCidades().addAll(listaPE);
        est18.getCidades().addAll(listaPI);
        est19.getCidades().addAll(listaRJ);
        est20.getCidades().addAll(listaRN);
        est21.getCidades().addAll(listaRS);
        est22.getCidades().addAll(listaRO);
        est23.getCidades().addAll(listaRR);
        est24.getCidades().addAll(listaSC);
        est25.getCidades().addAll(listaSP);
        est26.getCidades().addAll(listaSE);
        est27.getCidades().addAll(listaTO);

        cidadeRepository.saveAll(listaAC);
        cidadeRepository.saveAll(listaAL);
        cidadeRepository.saveAll(listaAP);
        cidadeRepository.saveAll(listaAM);
        cidadeRepository.saveAll(listaBA);
        cidadeRepository.saveAll(listaCE);
        cidadeRepository.saveAll(listaDF);
        cidadeRepository.saveAll(listaES);
        cidadeRepository.saveAll(listaGO);
        cidadeRepository.saveAll(listaMA);
        cidadeRepository.saveAll(listaMT);
        cidadeRepository.saveAll(listaMS);
        cidadeRepository.saveAll(listaMG);
        cidadeRepository.saveAll(listaPA);
        cidadeRepository.saveAll(listaPB);
        cidadeRepository.saveAll(listaPR);
        cidadeRepository.saveAll(listaPE);
        cidadeRepository.saveAll(listaPI);
        cidadeRepository.saveAll(listaRJ);
        cidadeRepository.saveAll(listaRN);
        cidadeRepository.saveAll(listaRS);
        cidadeRepository.saveAll(listaRO);
        cidadeRepository.saveAll(listaRR);
        cidadeRepository.saveAll(listaSC);
        cidadeRepository.saveAll(listaSP);
        cidadeRepository.saveAll(listaSE);
        cidadeRepository.saveAll(listaTO);

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, est9, est10, est11, est12, est13, est14, est15, est16,
                est17, est18, est19, est20, est21, est22, est23, est24, est25, est26, est27));

        Cliente cli1 = new Cliente(null, "Maria Silva", "mariasilva@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("teste"));
        Cliente cli2 = new Cliente(null, "Otavio Celestino", "otavio201378@gmail.com", "08696231090", TipoCliente.PESSOAFISICA, pe.encode("otaviocelestino"));

        cli2.addPerfil(Perfil.ADMIN);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
        cli2.getTelefones().addAll(Arrays.asList("979684822"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, listaSP.get(5));
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli2, listaSP.get(2));
        Endereco e3 = new Endereco(null, "Avenida Conselheiro", "3232", "", "Centro", "38777012", cli2, listaSP.get(10));

        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2,e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e1);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);

        ped1.setPagamento(pagto1);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itensPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
