import java.util.Random;

public class StructureMineshaftStart extends StructureStart {
   public StructureMineshaftStart(World par1World, Random par2Random, long par3, long par4) {
      ComponentMineshaftRoom componentmineshaftroom = new ComponentMineshaftRoom(0, par2Random, (par3 << 4) + 2L, (par4 << 4) + 2L);
      this.a.add(componentmineshaftroom);
      componentmineshaftroom.a(componentmineshaftroom, this.a, par2Random);
      this.c();
      this.a(par1World, par2Random, 10);
   }
}
