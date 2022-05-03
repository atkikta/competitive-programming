#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <cmath>

using namespace std;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
struct Monster{
    int id;
    int x;
    int y;
    int shield_life;
    int is_controlled;
    int health;
    int vx;
    int vy;
    int near_base;
    int therat_for;
    int targeted;
    void update(int x, int y, int shield_life, int is_controlled, int health, int vx, int vy, int near_base, int threat_for){
        x = x;
        y = y;
        shield_life = shield_life;
        is_controlled = is_controlled;
        health = health;
        vx = vx;
        vy = vy;
        near_base = near_base;
        threat_for = threat_for;
    }
};
struct Hero{
    int id;
    int x;
    int y;
    int shield_life;
    int is_controlled;
    int target;
    Hero(){

    }
    void update(int x, int y, int shield_life, int is_contrlled){
        x = x;
        y = y;
        shield_life = shield_life;
        is_controlled = is_controlled;
    }
};
struct Game{
    int health;
    int mana;
    int base_x;
    int base_y;
    map<int, Hero> heros;
    map<int, Monster> monsters;
    Game(int base_x, int base_y){
        base_x = base_x;
        base_y = base_y;
        heros = {};
        monsters = {};
    }
};

double distance(int x1, int y1, int x2, int y2){
    double dx1 = (double) x1;
    double dy1 = (double) y1;
    double dx2 = (double) x2;
    double dy2 = (double) y2;
    return sqrt((dx1-dx2)*(dx1-dx2) + (dy1-dy2)*(dy1-dy2));
}
int main()
{
    int base_x; // The corner of the map representing your base
    int base_y;
    cin >> base_x >> base_y; cin.ignore();
    int heroes_per_player; // Always 3
    cin >> heroes_per_player; cin.ignore();
    cerr << "create game "<< base_x << " "<< base_y << endl;
    Game game(base_x, base_y);
    // game loop
    while (1) {
        for (int i = 0; i < 2; i++) {
            int health; // Each player's base health
            int mana; // Ignore in the first league; Spend ten mana to cast a spell
            cin >> health >> mana; cin.ignore();
            game.mana = mana; //update mana and health
            game.health = health;
        }
        int entity_count; // Amount of heros and monsters you can see
        cin >> entity_count; cin.ignore();
        for (int i = 0; i < entity_count; i++) {
            int id; // Unique identifier
            int type; // 0=monster, 1=your hero, 2=opponent hero
            int x; // Position of this entity
            int y;
            int shield_life; // Ignore for this league; Count down until shield spell fades
            int is_controlled; // Ignore for this league; Equals 1 when this entity is under a control spell
            int health; // Remaining health of this monster
            int vx; // Trajectory of this monster
            int vy;
            int near_base; // 0=monster with no target yet, 1=monster targeting a base
            int threat_for; // Given this monster's trajectory, is it a threat to 1=your base, 2=your opponent's base, 0=neither
            cin >> id >> type >> x >> y >> shield_life >> is_controlled >> health >> vx >> vy >> near_base >> threat_for; cin.ignore();
            if(type==0){// insert monster to game hashmap
                if(game.monsters.find(id)==game.monsters.end()){
                    cerr << "create monster "<< id <<"x "<< x <<"y "<<y<< endl;
                    Monster m;
                    m.id = id;
                    m.x = x;
                    m.y = y;
                    m.shield_life = shield_life;
                    m.is_controlled = is_controlled;
                    m.health = health;
                    m.vx = vx;
                    m.near_base = near_base;
                    m.therat_for = threat_for;
                    game.monsters[id] = m;
                }else{
                    game.monsters[id].update(x, y, shield_life, is_controlled,health, vx, vy, near_base, threat_for);
                }
            }else if(type==1){// insert hero to game hashmap
                if(game.heros.find(id) == game.heros.end()){
                    cerr << "create hero "<< id << endl;
                    Hero h;
                    h.id = id;
                    h.x = x;
                    h.y = y;
                    h.target = -1;
                    h.shield_life;
                    h.is_controlled;
                    game.heros[id] = h;
                }else{
                    game.heros[id].update(x, y, shield_life, is_controlled);
                    // if current target not in game, reset to -1;
                    int current_target=game.heros[id].target;
                    if(game.monsters.find(current_target)==game.monsters.end()){
                        game.heros[id].target = -1;
                    }
                }
            }
        }
        for (const auto &item: game.heros) {
            Hero hero = item.second;
            int id = item.first;
            // Write an action using cout. DON'T FORGET THE "<< endl"
            // To debug: cerr << "Debug messages..." << endl;
            if(id==0){
                //targets the monster closest to the base
                if(hero.target ==-1){
                    int target = -1;
                    double min_dis = numeric_limits<double>::max()/2;
                    for(const auto& item: game.monsters){
                        int id = item.first;
                        Monster mon = item.second;
                        double dist = distance(mon.x+mon.vx, mon.y+mon.vy, game.base_x, game.base_y);
                        if(dist<min_dis){
                            min_dis = dist;
                            target= id;
                        }
                    }
                    hero.target = target;
                }
                if(hero.target != -1){
                    int target_x = game.monsters[hero.target].x +game.monsters[hero.target].vx;
                    int target_y = game.monsters[hero.target].y +game.monsters[hero.target].vy;
                    cout << "MOVE " << target_x << " " << target_y << " target id: " << hero.target <<" vx:"<<game.monsters[hero.target].vx<<" vy:"<<game.monsters[hero.target].vy<< endl;
                }else{
                    cout << "MOVE " << game.base_x << " " << game.base_y << endl;
                }
            }else if(id==1){
                int target = -1;
                double min_dis = numeric_limits<double>::max()/2;
                for(const auto& item: game.monsters){
                    int id = item.first;
                    Monster mon = item.second;
                    double dist = distance(mon.x+mon.vx, mon.y+mon.vy, game.base_x, game.base_y);
                    if(dist<min_dis && dist<500000){
                        min_dis = dist;
                        target= id;
                    }
                }
                hero.target = target;
                if(hero.target != -1){
                    int target_x = game.monsters[hero.target].x ;
                    int target_y = game.monsters[hero.target].y ;
                    cout << "MOVE " << target_x << " " << target_y << " target id: " << hero.target <<" vx:"<<game.monsters[hero.target].vx<<" vy:"<<game.monsters[hero.target].vy<< endl;
                }else{
                    cout << "MOVE " << game.base_x << " " << game.base_y << endl;
                }
            }else if(id==2){
                int target = -1;
                double min_dis = numeric_limits<double>::max()/2;
                for(const auto& item: game.monsters){
                    int id = item.first;
                    Monster mon = item.second;
                    double dist = distance(mon.x+mon.vx, mon.y+mon.vy, hero.x, hero.y);
                    if(dist<min_dis && dist<5000){
                        min_dis = dist;
                        target= id;
                    }
                }
                hero.target = target;
                if(hero.target != -1){
                    int target_x = game.monsters[hero.target].x +game.monsters[hero.target].vx;
                    int target_y = game.monsters[hero.target].y +game.monsters[hero.target].vy;
                    cout << "MOVE " << target_x << " " << target_y << " target id: " << hero.target <<" vx:"<<game.monsters[hero.target].vx<<" vy:"<<game.monsters[hero.target].vy<< endl;
                }else{
                    cout << "MOVE " << game.base_x << " " << game.base_y << endl;
                }
            }

            // In the first league: MOVE <x> <y> | WAIT; In later leagues: | SPELL <spellParams>;
            // cout << "WAIT" << endl;
        }
    }
    return 0;
}
