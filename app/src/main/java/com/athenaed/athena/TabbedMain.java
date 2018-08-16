package com.athenaed.athena;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.athenaed.athena.activities.ActivitiesFragment;
import com.athenaed.athena.classes.ClassActivity;
import com.athenaed.athena.classes.ClassesFragment;
import com.athenaed.athena.mundo.AthenaActivity;
import com.athenaed.athena.mundo.AthenaClass;
import com.athenaed.athena.mundo.AthenaStep;
import com.athenaed.athena.mundo.AthenaStudent;
import com.athenaed.athena.mundo.AthenaTeacher;
import com.athenaed.athena.profile.ProfileFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TabbedMain extends AppCompatActivity {

    private static final String TAG = "TabbedActivity";

    private static ArrayList<AthenaActivity> activitiesMain = new ArrayList<AthenaActivity>();
    private AthenaTeacher prof;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FirebaseDatabase mFireDataBase;
    private DatabaseReference mActivitiesDataBaseReference;
    private ChildEventListener mChildEventListener;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Info
        prof = new AthenaTeacher("Julia Torres Sarmiento","Colegio de Prueba XVI",5,5,5,new ArrayList<AthenaClass>(),new ArrayList<AthenaActivity>());


        AthenaClass clasetemp1 = new AthenaClass(new ArrayList<AthenaStudent>(),"auditivo","Sexto B", "Clase muy tranquila, callados y respetuosos. Atienden muy bien a clase.", R.drawable.class_1,8,2,4,5);
        AthenaClass clasetemp2 = new AthenaClass(new ArrayList<AthenaStudent>(),"auditivo","Octavo C", "Dispersos y en ocasiones muy habladores. Pero bastante responsable socn los trabajos.", R.drawable.class_2,2,5,7,6);
        AthenaClass clasetemp3 = new AthenaClass(new ArrayList<AthenaStudent>(),"kinestesico","Octavo A", "Una de las mejores clases del colegio, atienden de forma respetuosa y su responsabilidad con trabajos es ejemplar.", R.drawable.class_3, 8,2,4,1);
        AthenaClass clasetemp4 = new AthenaClass(new ArrayList<AthenaStudent>(),"kinestesico","Sexto A", "Clase juiciosa y dedicada, con algunos distraidos, pero en general buenos estudiantes todos.", R.drawable.class_2, 8,2,4,3);
        AthenaClass clasetemp5 = new AthenaClass(new ArrayList<AthenaStudent>(),"visual","Decimo C", "El decimo más complicado, se distren bastante y se faltan demasiado alr espeto entre ellos. No estan mal academicamente pero les falta convivencia.", R.drawable.class_3,8,2,4,8);
        AthenaClass clasetemp6 = new AthenaClass(new ArrayList<AthenaStudent>(),"kinestesico","Decimo A", "Una clase muy interesante de trabajar, los estudiantes atienden a las clases y participan de manera activa, proponiendo siempre, apropiendose de su proceso de aprendizaje.",R.drawable.class_1,8,2,4,7);
        AthenaClass clasetemp7 = new AthenaClass(new ArrayList<AthenaStudent>(),"visual","Decimo B", "Muy respondables con los trabajos, pero hace falta mayor participacion en clase, muy pocos se preocupan por participar y apropiarse de los temas vistos.", R.drawable.class_2,8,2,4,6);
        AthenaClass clasetemp8 = new AthenaClass(new ArrayList<AthenaStudent>(),"visual","Sexto C", "Estudiantes aplicados, con excepcion de unos pocos que presentan graves problemas de atencion y trabajo en grupo.", R.drawable.class_1,8,2,4,7);
        AthenaClass clasetemp9 = new AthenaClass(new ArrayList<AthenaStudent>(),"kinestesico","Octavo B", "Una clase muy alegre y despuesta a aprender en todo momento, solo cuenta con un caso complciado, pero son estudiantes que valoran el trabajo en equipo y hacen uso de este en todo momento.", R.drawable.class_3,8,2,4,9);


        ArrayList<AthenaStep> pasos1 = new ArrayList<>();
        ArrayList<AthenaStep> pasos2 = new ArrayList<>();
        ArrayList<AthenaStep> pasos3 = new ArrayList<>();
        ArrayList<AthenaStep> pasos4 = new ArrayList<>();
        ArrayList<AthenaStep> pasos5 = new ArrayList<>();

        pasos1.add(new AthenaStep("Dividir el tema en frases significativas(preferiblemente que sean la cantidad de estudiantes divididos 3) y organizar las mismas en pequeños párrafos que las justifiquen.", -1));
        pasos1.add(new AthenaStep( "Dividir el salón de clases en grupos de entre 3 y 4 personas. Esto se hace para incentivar trabajo en equipo.", R.drawable.rompecabezas_2));
        pasos1.add(new AthenaStep( "Posterior a tener los equipos formados, hacer dictado de los párrafos con las frases. Preferiblemente, que la cantidad de párrafos sea igual a la de los grupos y hacer que cada grupo lea un párrafo.", R.drawable.memo_1));
        pasos1.add(new AthenaStep( "Dar 20 minutos para que los estudiantes armen las frases significativas de los párrafos leídos por todo grupo excluyendo el propio.",R.drawable.rompecabezas_3));

        pasos2.add(new AthenaStep("Iniciar con el envío de lecturas previas sobre el tema a los distintos estudiantes.", -1));
        pasos2.add(new AthenaStep( "Sobre los temas más importantes de las lecturas, crear diapositivas con información faltante para ser completada.", R.drawable.procesos_2));
        pasos2.add(new AthenaStep( "Poner reglas para pedir palabra a los estudiantes al intentar llenar la información.", R.drawable.memoria_1));
        pasos2.add(new AthenaStep( "Con estas reglas, pasar diapositiva por diapositiva para hacer que los estudiantes compitan por llenarlas.",R.drawable.procesos_1));
        pasos2.add(new AthenaStep("Al acabar la actividad, recompensar con algo al estudiante con mayor cantidad de puntos o hacer esta actividad como quiz de lectura previa", R.drawable.memoria_1));

        pasos3.add(new AthenaStep( "Prepara el tema sobre un procedimiento con los pasos de forma visual(Diapositivas, por ejemplo).", -1));
        pasos3.add(new AthenaStep( "Separar de los pasos la justificación de por qué el proceso es importante para el área, a manera de dictado.", R.drawable.procesos_1));
        pasos3.add(new AthenaStep( "Mostrar a la clase el procedimiento sin dar explicación específica de cada paso, mientras tanto, hablar de la importancia del proceso.", R.drawable.memo_1));
        pasos3.add(new AthenaStep( "Pedir a cada estudiante que modele, según los temas, los dos pasos más importantes del proceso según lo que vio y escuchó. Preferiblemente hacerlo con plastilina(u otro material parecido) o un dibujo en caso de que no haya materiales.", R.drawable.procesos_2));
        pasos3.add(new AthenaStep( "Luego de la entrega, explicar el paso a paso del proceso. Al conocer la importancia del mismo y haber modelado lo que consideraban más importante, los estudiantes serán más propensos a entender el mismo.", R.drawable.procesos_1));

        pasos4.add(new AthenaStep( "Enviar detalles del experimento a los estudiantes.", -1));
        pasos4.add(new AthenaStep( "Preparar el mismo experimento para que se haga frente a ellos.", R.drawable.experimentacion_1));
        pasos4.add(new AthenaStep( "Demostrar el experimento frente a los estudiantes para que sea repetible al inicio de la clase", R.drawable.experimentacion_2));
        pasos4.add(new AthenaStep( "Dejar que los estudiantes hagan el experimento.", R.drawable.procesos_2));

        pasos5.add(new AthenaStep( "Preparar el experimento paso a paso en forma de dictado, oral.", -1));
        pasos5.add(new AthenaStep( "Dividir a los estudiantes en grupos para el experimento.", R.drawable.experimentacion_2));
        pasos5.add(new AthenaStep( "Explicar de forma oral el experimento a los estudiantes sin permitir que inicien hasta el final del dictado.", R.drawable.memoria_3));
        pasos5.add(new AthenaStep( "Hacer que los estudiantes hagan el experimento.", R.drawable.procesos_2));


        prof.activities.add(new AthenaActivity("Recontruye El Dictado","Se enseña por un rompecabezas con frases e información en grupos de reorganizar información dada por un dictado. En grupos de 3 estudiantes. Trabaja comunicación, memoria, trabajo en equipo y el tema.(Además de kinestésico y auditivo)",R.drawable.rompecabezas_2,4,8,2,pasos1));
        prof.activities.add(new AthenaActivity("Diapositivas Sin Memoria","Uso de lecturas previas sobre el tema para luego mostrar diapositivas incompletas incentivando competencia al dar algún premio a los estudiantes que vayan completando la información. Enseña memoria, incentiva competencia entre estudiantes y da mayor interés por la clase al sentirse como un juego (además de ser visual)",R.drawable.memoria_1,5,5,5,pasos2));
        prof.activities.add(new AthenaActivity("Procesos Incompletos","Uso de actividad en que se muestran pasos de un proceso de forma visual mientras se explica auditivamente el por qué se hace. Posteriormente, se pide dibujar o hacer en algún material los dos pasos más importantes del proceso. Al estar disociada la parte visual de la auditiva, la parte kinestésica requiere la atención de ambos. Con esto, sirve para entrenamiento total de habilidades enseñando diferentes datos por cada metodología",R.drawable.procesos_1,5,5,5,pasos3));
        prof.activities.add(new AthenaActivity("Experimento Visual","Se envían detalles para el experimento previos a hacer el mismo. Posteriormente, un grupo lo hace frente a todos para que se explique el cómo hacerlo. Luego de esto, los mismos estudiantes deben repetir el experimento para hacerlo de forma práctica.",R.drawable.rompecabezas_2,1,8,2,pasos4));
        prof.activities.add(new AthenaActivity("Experimento Memoria","Esto se debe hacer con un tema que minimice el riesgo de los estudiantes. El experimento iniciará con la explicación del mismo de forma auditiva. Al tener esto, se dejará que los estudiantes aprendan del tema de forma práctica.",R.drawable.memoria_1,3,6,2,pasos5));



        clasetemp1.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp1.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp1.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp1.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp1.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp1.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp1.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp1.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp1.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp1.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp2.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp2.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp2.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp2.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp2.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp2.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp2.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp2.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp2.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp2.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp3.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp3.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp3.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp3.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp3.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp3.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp3.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp3.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp3.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp3.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp4.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp4.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp4.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp4.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp4.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp4.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp4.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp4.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp4.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp4.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp5.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp5.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp5.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp5.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp5.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp5.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp5.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp5.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp5.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp5.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp6.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp6.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp6.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp6.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp6.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp6.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp6.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp6.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp6.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp6.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp7.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp7.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp7.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp7.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp7.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp7.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp7.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp7.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp7.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp7.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp8.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp8.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp8.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp8.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp8.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp8.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp8.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp8.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp8.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp8.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        clasetemp9.students.add(new AthenaStudent("Alberto Zapata", R.drawable.student_2, 4.12,9.6,8.7,9.08,2.4,8.8,6.0,5.0,"Es excelente en lenguaje, naturales y la parte corporal pero no es bueno aprendiendo sobre matemáticas. Se depende de que en matemáticas se le enseñe de formas relacionadas con lenguaje o algo natural para fijar conocimiento."));
        clasetemp9.students.add(new AthenaStudent("Aida Velez", R.drawable.student_3, 8.8,4.9,7.9,4.0,7.4,7.7,4.1,6.6,"En general, es una estudiante íntegra. Sus mayores debilidades están en el aprender de lenguajes y de sí misma pero, por lo demás, es posible enseñarle sin problemas. Su habilidad matemática puede crecer fácilmente debido a que se le facilita el aprendizaje en esta área."));
        clasetemp9.students.add(new AthenaStudent("German Toro", R.drawable.student_4, 3.5,5.6,5.2,7.3,5.9,8.9,8.9,3.8,"Su conocimiento de sí mismo y de la parte naturalista es excelente. Pero, en general, enseñarle de forma visual y musical es complicado. Por esto, se recomienda el evitar  enseñarle de esta forma. Su habilidad lingüística no es la mejor entre los estudiantes de su clase."));
        clasetemp9.students.add(new AthenaStudent("Alba Restrepo", R.drawable.student_5, 7.8,6.4,9.0,2.1,1.3,2.9,6.1,1.6,"Brilla en inteligencia interpersonal, siendo un estudiante perfecto para recibir o dar tutorías. Pero se debe evitar enseñarle de forma matemática o visual, pues sus falencias son enormes en estas áreas. Es un estudiante que ayuda a sus compañeros cuando se encuentran con alguna dificultad."));
        clasetemp9.students.add(new AthenaStudent("Mateo Ortiz", R.drawable.student_6, 9.4,8.2,8.4,7.8,7.9,2.8,9.2,6.0,"Su conocimiento de sí mismo y de la parte musical es casi perfecto, aprendiendo de esta forma rápidamente. Adicionalmente, sólo presenta falencias en el conocimiento naturista. Por ende, se conoce como perfil de estudiante estrella."));
        clasetemp9.students.add(new AthenaStudent("Alfonso Molina", R.drawable.student_2, 5.3,5.8,5.4,4.1,4.3,9.7,9.1,2.6,"Su conocimiento de sí mismo y de la parte naturista es muy superior a la media, siendo excelente en aprender de estas áreas. Además de esto, su única falencia real es en el aprendizaje visual. Por lo demás, puede marcar el promedio en las distintas clases por sus habilidades."));
        clasetemp9.students.add(new AthenaStudent("Juliana Rodriguez", R.drawable.student_3,9.7,4.1,5.4,1.5,8.8,2.7,4.4,1.0,"Su inteligencia visual y lingüística deja mucho que desear, debiendose evitar el enseñarle con estos métodos. Pero, por parte musical, es de las mejores estudiantes deseables. Además, su habilidad matemática es la mejor de la clase."));
        clasetemp9.students.add(new AthenaStudent("Nelli Diaz", R.drawable.student_4, 1.3,5.8,7.2,6.7,1.6,2.8,3.7,1.3,"Es una estudiante que siempre está para ayudar a sus compañeros cuando necesitan de su ayuda. Su habilidad matemática es una de las mejores, por lo que hay que centrarse en este campo al enseñarle nuevos temas."));
        clasetemp9.students.add(new AthenaStudent("Zara Torres", R.drawable.student_4,2.2,1.8,4.8,1.2,6.7,2.5,3.4,8.8,"Su capacidad musical no es tan buena cuando se compara con otros estudiantes. Es una estudiante que se le facilita el aprendizaje auditivo. Hay que intentar enseñarle utilizando este tipo de aprendizaje para sacar de mejor de ella."));
        clasetemp9.students.add(new AthenaStudent("Fabian Moreno", R.drawable.student_4,8.3,6.7,6.7,9.4,4.2,5.5,6.9,4.6,"Es uno de los mejores estudiantes en cuanto al área de música. Es por esto que siempre muestra buenos resultados si se trata de este campo. En general es un estudiante que se le facilita todo tipo de aprendizaje."));

        prof.classes.add(clasetemp1);
        prof.classes.add(clasetemp2);
        prof.classes.add(clasetemp3);
        prof.classes.add(clasetemp4);
        prof.classes.add(clasetemp5);
        prof.classes.add(clasetemp6);
        prof.classes.add(clasetemp7);
        prof.classes.add(clasetemp8);
        prof.classes.add(clasetemp9);

        mFireDataBase = FirebaseDatabase.getInstance();
        mActivitiesDataBaseReference = mFireDataBase.getReference().child("Activities");

        setContentView(R.layout.activity_tabbed);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewerPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        mActivitiesDataBaseReference.addChildEventListener(mChildEventListener);
    }


    private void setupViewerPager(ViewPager viewPager){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //Fragmento de perfil
        ProfileFragment fragmentProfile = new ProfileFragment();
        Bundle infoProfile = new Bundle();
        infoProfile.putParcelable("dataTeacher",prof);
        fragmentProfile.setArguments(infoProfile);
        adapter.addFragment(fragmentProfile, "Profile");

        //Fragmento de Clases
        ClassesFragment classesFragment = new ClassesFragment();
        Bundle infoClasses = new Bundle();
        infoClasses.putParcelableArrayList("dataClasses", prof.classes);
        classesFragment.setArguments(infoClasses);
        adapter.addFragment(classesFragment, "Classes");

        //Fragmento de Actividades
        Fragment activitiesFragment = new ActivitiesFragment();
        Bundle infoActivities = new Bundle();
        infoActivities.putParcelableArrayList("dataActivities",prof.activities);
        activitiesFragment.setArguments(infoActivities);
        adapter.addFragment(activitiesFragment, "Activities");

        viewPager.setAdapter(adapter);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        private List<Fragment> mfragmentsList = new ArrayList<>();
        private List<String> mfragmentsTitlesList = new ArrayList<>();


        public void addFragment(Fragment fragment , String title){
            mfragmentsList.add(fragment);
            mfragmentsTitlesList.add(title);
        }

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mfragmentsTitlesList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mfragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return mfragmentsList.size();
        }
    }
}
