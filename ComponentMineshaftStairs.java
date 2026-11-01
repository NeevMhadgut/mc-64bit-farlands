import java.util.List;
import java.util.Random;

public class ComponentMineshaftStairs extends StructureComponent {
   public ComponentMineshaftStairs(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   public static StructureBoundingBox findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5) {
      StructureBoundingBox structureboundingbox = new StructureBoundingBox(par2, par3 - 5, par4, par2, par3 + 2, par4);
      switch (par5) {
         case 0:
            structureboundingbox.d = par2 + 2L;
            structureboundingbox.f = par4 + 8L;
            break;
         case 1:
            structureboundingbox.a = par2 - 8L;
            structureboundingbox.f = par4 + 2L;
            break;
         case 2:
            structureboundingbox.d = par2 + 2L;
            structureboundingbox.c = par4 - 8L;
            break;
         case 3:
            structureboundingbox.d = par2 + 8L;
            structureboundingbox.f = par4 + 2L;
      }

      return StructureComponent.a(par0List, structureboundingbox) != null ? null : structureboundingbox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      int i = this.c();
      switch (this.h) {
         case 0:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b, this.g.f + 1L, 0, i);
            break;
         case 1:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a - 1L, this.g.b, this.g.c, 1, i);
            break;
         case 2:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.a, this.g.b, this.g.c - 1L, 2, i);
            break;
         case 3:
            StructureMineshaftPieces.getNextComponent(par1StructureComponent, par2List, par3Random, this.g.d + 1L, this.g.b, this.g.c, 3, i);
      }
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 0L, 2L, 7, 1L, 0, 0, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 0, 7L, 2L, 2, 8L, 0, 0, false);

      for (int i = 0; i < 5; i++) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5 - i - (i >= 4 ? 0 : 1), 2 + i, 2L, 7 - i, 2 + i, 0, 0, false);
      }

      return true;
   }
}
