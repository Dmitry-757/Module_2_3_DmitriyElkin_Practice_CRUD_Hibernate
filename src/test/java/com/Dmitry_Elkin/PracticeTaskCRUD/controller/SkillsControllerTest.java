package com.Dmitry_Elkin.PracticeTaskCRUD.controller;


import com.Dmitry_Elkin.PracticeTaskCRUD.model.Developer;
import com.Dmitry_Elkin.PracticeTaskCRUD.model.Skill;
import com.Dmitry_Elkin.PracticeTaskCRUD.model.Specialty;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.DeveloperRepository;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.SkillRepository;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.Hibernate.SpecialtyRepository;
import com.Dmitry_Elkin.PracticeTaskCRUD.repository.jdbc.SkillRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class SkillsControllerTest {


    @Mock
    SkillRepository mockRepository;

    SkillController controller;

    @BeforeEach
    void setUp() {
        controller = new SkillController();
        Field repository;
        try {
            repository = controller.getClass()
                    .getDeclaredField("repository");
            repository.setAccessible(true);
            repository.set(controller, mockRepository);
        } catch (NoSuchFieldException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    void getAllItemsTest(){

        List<Skill> items = new LinkedList<>();
        items.add(new Skill("Item 1"));
        items.add(new Skill("Item 2"));

        Mockito.when(mockRepository.getAll()).thenReturn(items);//задаем поведение для заглушки

        assertThat(controller.getAll()).isEqualTo(items);
        Mockito.verify(mockRepository).getAll();
    }

    @Test
    void getItemByIdTest(){

        Skill item = new Skill("Item 1");
        Mockito.when(mockRepository.getById(1L)).thenReturn(item);//задаем поведение для заглушки

        assertThat(controller.getById(1L)).isEqualTo(item);
        Mockito.verify(mockRepository).getById(1L);
    }


    @Test
    public void createNewItemTest(){
        Skill item = new Skill("Test Item");
        Skill expectedItem = new Skill(1L,"Test Item");
        Mockito.when(mockRepository.insert(item)).thenReturn(expectedItem);//задаем поведение для заглушки

        assertThat(controller.insert(item)).isEqualTo(expectedItem);
        Mockito.verify(mockRepository).insert(item);

    }

    @Test
    public void updateItemTest(){
        Skill item = new Skill(2L,"updated Item");
        Skill expectedItem = new Skill(2L,"updated Item");
        Mockito.when(mockRepository.update(item)).thenReturn(expectedItem);//задаем поведение для заглушки

        assertThat(controller.update(item)).isEqualTo(expectedItem);
        Mockito.verify(mockRepository).update(item);
    }



//    @Test
//    public void SControllerTest_Insert(){
//        SpecialtyView controller = new SpecialtyView(mockRepository);
//
//        InputStream inputStream = System.in;  // сохраняем ссылку на ввод с клавиатуры
//        System.setIn(new ByteArrayInputStream("1\nTest Specialty\n0\n0\n".getBytes())); // подменяем ввод
//        controller.menu();
//        System.setIn(inputStream);            // подменяем обратно
//
//        Mockito.verify(mockRepository).addOrUpdate(new Specialty("Test Specialty"));
//    }

    @Test
    public void insertTest(){
        Specialty specialty = new Specialty("specialty");
        SpecialtyRepository specialtyRepository = new SpecialtyRepository();
        specialtyRepository.insert(specialty);

        Skill skill1 = new Skill("Skill 1");
        Skill skill2 = new Skill("Skill 2");
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.insert(skill1);
        skillRepository.insert(skill2);

        HashSet<Skill> skills = new HashSet<>();
        skills.add(skill1);
        skills.add(skill2);

        DeveloperRepository developerRepository = new DeveloperRepository();

        Developer developer = new Developer("firstName", "lastName", skills, specialty);
        developerRepository.insert(developer);
        System.out.println(developer);
        Developer dev2 = developerRepository.getById(developer.getId());
        System.out.println(dev2);
    }

}