package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class JoggingActivity : AppCompatActivity() {

    lateinit var  myRecyclerView: RecyclerView
    lateinit var  joggingArticleArrayList: ArrayList<JoggingArticle>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogging)



        myRecyclerView = findViewById(R.id.recyclerView)

        var joggingArticleImageArray = arrayOf(
            R.drawable.j1 ,
            R.drawable.jogging1 ,
            R.drawable.jogging2 ,
            R.drawable.jogging3 ,
            R.drawable.jogging4,
            R.drawable.pngimage1 ,



        )
        var joggingHeading = arrayOf(
            "What Is Jogging?" ,
            "Health Benefits Of Jogging Everyday Morning" ,
            "Best Time To Go For Jogging " ,
            "How to do Jogging the Correct way " ,
            "How to choose best shoes for jogging " ,
            "Does jogging reduce weight? " ,
        )

        val joggingarticlecontent = arrayOf(
            "Running at a slower pace is referred to as jogging. When you place your feet on the ground, you take smaller steps and cover less land. The benefit of jogging is that you can maintain your tempo for longer," +
                    " use less energy, and eventually run further! This way, you can prepare for a 10K, 15K, Half Marathon (21K), or even a marathon (42K)! . \n" +
                    "\n"+
                    "There is no way to determine a specific pace (or speed) because everyone runs at their own rate. Just bear in mind that it should be somewhere in the middle of your walking and running paces. " +
                    "Running slower than 6 miles/10 kilometres per hour is one definition of jogging, however, this can be difficult if you are new " +
                    "to running or too sluggish if you are an experienced runner. \n " +

                    " \n " +
                      "For example \n" +
            "I'm a seasoned runner (I've been jogging for over three years). Depending on the distance, my running speed is around 14 km per hour (4:17 min/km). My pace lowers to 12 km per hour (5:00 min/km) when I'm jogging. \n"+
            "\n"+
            "Dropping 2 kilometres per hour may not seem like much, but it makes a significant difference in my energy. This way, I'll be able to stay up for longer than when I'm jogging, and eventually run further to increase my distance training.",

            "Regular exercise has a huge impact on our overall well-being, as we all know. Depending on the type of exercise you do, you can reap a variety of benefits. In the section below, we'll go through the specific benefits of jogging regularly.\n" +
                    "\n" +
                    "1. Improves Cardiovascular Fitness\n" +
                    "The cardiovascular system, which includes the heart, lungs, and blood vessels, is the most visible consequence of jogging on the body. You're probably aware that when you exercise, your body responds by raising your heart rate and breathing rate to meet the demands of the activity. The goal is to keep providing oxygen-rich blood to the working muscles so that they can use it for energy. This increase will also allow waste products such as carbon dioxide to be removed from the body. The strength and function of the cardiovascular system, notably your resting heart rate, improves when you jog regularly.\n" +
                    "\n" +
                    "2. Builds Muscle Strength\n" +
                    "To perform the movements required for running, several muscles must be regularly contracted. The glutes, quadriceps, hamstrings, and calves are the muscles of the lower extremities that are principally responsible for mobility. While the legs push back and forth, the core and upper body muscles must activate to rotate and stabilise the trunk. Regular jogging will put stress on these muscles, forcing them to adapt and grow stronger. Muscle strength will have a favourable impact on how you move and reduce your chance of injury. \n" +
                    "\n" +
                    "3. Improved Muscular Endurance\n" +
                    "Muscular endurance refers to the muscles' ability to perform repetitive contractions for an extended amount of time without rest. To maintain a jogging pace, the muscles must be capable of continuously contracting. The muscles will begin to adapt and their endurance capacity will improve with regular jogging. Because jogging workouts are often long in duration but low in intensity, it is particularly useful for building muscle endurance.\n" +
                    "\n" +
                    "4. Stronger Bones\n" +
                    "Jogging affects bone density in addition to muscle strength and endurance. The amount of bone mineral contained within the bone is referred to as bone density, and having a high bone density boosts the bone's strength. The impacts involved with the foot strike in running have regularly been proven to help develop bone density in studies. As a result, it can be inferred that jogging improves bone health and reduces the risk of developing bone-wasting illnesses like osteoporosis.\n" +
                    "\n" +
                    "5. Facilitates Weight Loss\n" +
                    "To lose weight, a negative energy balance must be achieved, which means that more calories are spent each day than are consumed. Maintaining a negative energy balance causes the body to break down body fat to provide a steady supply of energy. While nutrition will play a key role in a negative energy balance, sports such as jogging will burn a considerable number of calories and hence aid in weight loss.\n" +
                    "\n" +
                    "6. Boost the Immune System\n" +
                    "It's been reported that running can boost the immune system's effectiveness. The immune system has been proven to be particularly responsive to exercise in studies that have looked into the impact of regular exercise on immunity. Exercise may increase the production of lymphocytes and macrophages, which attack foreign substances in the body to fight illness or infection. While strengthening the immune system may not immediately lessen the likelihood of developing a cold or the flu, it does affect the time it takes to recover from such an illness.\n" +
                    "\n" +
                    "7. Active Recovery\n" +
                    "Jogging might help you recuperate faster from intensive exercise sessions. The muscles of the body can experience delayed onset muscle pain after a strenuous strength training session or a demanding run (or DOMS). This could be debilitating for a few days after training while your body recovers. Active recovery, which is a technique for speeding up recovery, can be quite beneficial. Active recovery is low-intensity activity that promotes the circulation of oxygen-rich blood to exhausted muscles, hence speeding up recovery and minimising discomfort. Because jogging is a low-intensity exercise, it can be used as an active recovery therapy.\n" +
                    "\n" +
                    "8. Reduced Risk of Diseases\n" +
                    "Jogging, as previously said, can improve cardiovascular health as well as muscular and bone strength. Maintaining cardiovascular fitness has been shown to lower the risk of some heart disorders, such as coronary heart disease and strokes. Regular exercise helps to build strong muscles and bones, which lowers the risk of getting a muscle and bone wasting disease.\n" +
                    "\n" +
                    "9. Better sleep\n" +
                    "A good night's sleep is critical to your overall health. When you sleep, your body heals itself, which is why you feel refreshed when you wake up. However, try not to run too late in the day. This can make it difficult to get a good night's sleep. Endorphins, which assist reduce pain and tension, are released during aerobic activity. These stimulate the brain and may cause you to stay awake.\n" +
                    "\n" +
                    "10. Improves Mental Health\n" +
                    "Finally, jogging can have more than simply a bodily influence. Aerobic workouts have regularly been shown in studies to greatly improve mental health and prevent the onset of mental disease. When it comes to mental health issues like sadness and anxiety, running can assist to alleviate the symptoms.",


            "There are benefits and drawbacks to jogging at different times of the day, as well as distinct training effects. When planning your jogs, keep your personal goals in mind. Do you want to lose weight, reduce stress, improve your speed, or jog a longer distance? The optimum time to jog is when it feels the most natural to you. Daily schedules, sleep patterns, work, leisure time, family, and eating times are all important considerations when organising your jogs.\n" +
                    "\n" +
                    "A) Jogging in the morning:-\n" +
                    "Advantages:\n" +
                    "\n"+
                    "A morning jog is an excellent way to begin the day.\n" +
                    "You may give your body a healthy dosage of oxygen by jogging in the morning. Your metabolism will be accelerated, causing you to burn more calories.\n" +
                    "Morning air has a higher oxygen content, making it easier to breathe, especially in the heat. In comparison to the midday heat, it's also easier to run when it's still cool.\n" +
                    "\n "+
                    "Disadvantages:\n" +
                    "\n"+
                    "  Morning jogging can be more difficult than other times of the day.\n" +
                    "Your joints may be stiff when you first wake up, and your muscles may be tense and inflexible. This means that when you jog, you lack the requisite muscle control and coordination. That's why you should do a unique, dynamic warm-up program before you run in the mornings so you don't have to fight muscle resistance when jogging. \n" +
                    "\n" +
                    "B)  Jogging in the lunchtime:-\n" +
                    "\n"+
                    "Advantages:\n" +
                    "\n"+
                    "The optimal time for a high-intensity jog is around the midday hours.\n" +
                    "Around midday, your performance potential is at its peak, and your body is not overworked from your daily activities. When compared to the morning, your energy stores are full, and physical exertion feels less severe. This is the ideal weather for a vigorous training jog. The body responds well to speed training in the middle of the day. \n" +
                    "Disadvantages:\n" +
                    "\n"+
                    "Jogging after lunch can be taxing.\n" +
                    "Depending on how heavy and rich your lunch was, your body will need extra time to digest it.\n" +
                    "\n" +
                    " C) Running in the evening:-\n" +
                    "\n"+
                    "Advantages:\n" +
                    "\n"+
                    "Jogging in the evening is a great way to unwind.\n" +
                    "Do you find it difficult to unwind at the end of a long day at work? A low-intensity endurance jog can help you de-stress. You don't need to warm up as much as you would in the morning because your body is still in performance mode. A calm nighttime jog also helps you burn fat at night.\n" +
                    "Disadvantages:\n" +
                    "\n"+
                    "It can be difficult to fall asleep after an evening jog.\n" +
                    "Perhaps a high-intensity jog in the evening would help you blow off some steam. However, you should be aware that you may find it difficult to go asleep because your body has been re-energized by the workout.\n",


            "If you're new to jogging, check out the beginner jogging suggestions below.\n" +
                    " Preparation of equipment: \n " +
                    "Jogging takes very little equipment, but one of the most significant items is jogging shoes. To lower your chance of injury and enhance your health, you should invest in a nice pair of jogging shoes.\n" +
                    "\n"+
                    "Identify your location: \n" +
                    " Decide where you want to go jogging. Jogging can be done outside or on a treadmill indoors. Terrain, weather, safety, timing, and the surroundings are all factors to consider.\n" +
                    "\n"+

                    "Start by walking: \n " +
                    "If you're new to exercising or out of shape, start by walking to allow your body time to adjust. 3-4 times a week, walk for 15-30 minutes and progressively raise your walking pace to jogging.\n" +
                    "Warm up: \n " +
                    "Before each jog, remember to stretch. Stretching keeps your muscles flexible, reducing the risk of injury and pressure on your body.\n" +
                    "Pace yourself: \n" +
                    "Take it easy the first few times you jog. 5 minutes of jogging followed by 2 minutes of walking This will help your body to acclimatise to the training and become accustomed to it.\n" +
                    "Adopt the correct jogging form: \n" +
                    "Using the correct jogging form might help you perform better. When jogging, keep your upper body relaxed and prevent heel-striking. Learn to jog long with your arms at a 90-degree angle and parallel to your torso. By synchronising your breathing with your steps, you may maintain a normal breathing pattern.\n" +
                    "Plan a jogging schedule: \n" +
                    "If your ultimate jogging goal is to jog a full marathon, you need establish and keep to a regular jogging schedule. Once you've established a regular jogging routine and improved your fitness level, you can go to a marathon training programme. You might want to hire a jogging coach to help you with your marathon training strategy.\n" +
                    "Utilize technology: \n" +
                    " There are several free fitness and jogging applications available that can measure your pace, distance, time, and calories expended. You may also acquire a fitness tracker or gadget to measure your heart rate, progress, and other jogging statistics in greater detail if you've become a more dedicated jogger.\n" +
                    "Increase your exercises: \n" +
                    "As your fitness level improves, you should increase your workouts to avoid being stuck in a jogging rut. You may also liven up your jogging routines by adding different terrain to your route, such as trails, hills, or stairs, inserting intervals in your jog, travelling for long distances, and playing another jogging game, such as picking a landmark and sprinting to it.\n" +
                    "Locate a jogging partner or a jogging group: \n" +
                    "jogging alongside another person might help you stay motivated.",

            "A nice pair of jogging shoes is required for proper jogging. Although jogging is not as strenuous as jogging, it is still necessary to invest in a decent pair of jogging shoes to avoid injuries. Keep the following points in mind while shopping for jogging shoes:\n" +
                    "Wear appropriate running or jogging shoes. Jogging shoes should be somewhat larger than regular shoes. When you buy new shoes, get your feet sized.\n" +
                    "The jogging shoes should be soft and comfortable, with shock-absorbing padding in the heel and little or no sliding.\n" +
                    "${R.drawable.pngimage1}"+
                    "Bring your old jogging shoes, socks, and any inserts with you when you go shoe shopping so you can get a true idea of how well the new shoe will fit your feet.\n" +
                    "Make certain there is some wriggle space. Between the end of your longest toe and the front of the shoe, there should be roughly a thumb's breadth of space." ,


            "One of the primary benefits of jogging is that it helps people to reduce their weight. Jogging burns more calories than practically any other aerobic activity. Jogging benefits in getting skinny since the recipe for weight reduction is to burn more calories than you intake. With a specific training regimen, you can lose weight by jogging for 20 minutes.\n" +
                    "\n" +
                    "Make a list of your weight-loss objectives and make sure they're attainable. Each week, keep track of and record your weight to see how far you've come. Losing one to two pounds per week is considered a healthy, long-term weight loss pace. One pound is around 3,500 calories, therefore if you burn 500 more calories every day than you consume, you will lose one pound in a week. To achieve your weight-loss objectives, you may need to alter your diet.\n" +
                    "\n" +
                    "If you're new to jogging, start with a walking and jogging programme and progressively increase your jogging minutes until you can complete the entire 20-minute jog. Starting a jogging programme without any prior expertise or training will rapidly turn you off.\n" +
                    "\n" +
                    "Interval walking is a good way to get in some exercise. Three to four minutes of vigorous walking, followed by 30 seconds of jogging For the entire 20 minutes, alternate between the two. You're gaining the strength you'll need to maintain a 20-minute jog throughout this period. The number of calories you burn throughout each jog is determined by your weight and jogging pace."

        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        joggingArticleArrayList = arrayListOf<JoggingArticle>()

        for ( index in joggingArticleImageArray.indices){
            val article = JoggingArticle(joggingHeading[index] , joggingArticleImageArray[index]
                ,joggingarticlecontent[index] )
            joggingArticleArrayList.add(article)
        }
         var myAdapter = MyAdapter(joggingArticleArrayList , this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListener(object :MyAdapter.OnItemClickeListener{
            override fun onItemclick(position: Int) {

                // on clicking Each item

                val intent = Intent(this@JoggingActivity , JoggingArticleDetailActivity::class.java)
                intent.putExtra("heading" ,joggingArticleArrayList[position].ArticleHeading)
                intent.putExtra("imageid" ,joggingArticleArrayList[position].ArticleImage)
                intent.putExtra("content" ,joggingArticleArrayList[position].Articlecontent)
                startActivity(intent)
            }

        })



    }


}