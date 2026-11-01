import java.util.List;
import java.util.Random;

abstract class ComponentNetherBridgePiece extends StructureComponent {
   protected ComponentNetherBridgePiece(int par1) {
      super(par1);
   }

   private int a(List par1List) {
      boolean flag = false;
      int i = 0;

      for (ahk structurenetherbridgepieceweight : par1List) {
         if (structurenetherbridgepieceweight.d > 0 && structurenetherbridgepieceweight.c < structurenetherbridgepieceweight.d) {
            flag = true;
         }

         i += structurenetherbridgepieceweight.b;
      }

      return flag ? i : -1;
   }

   private ComponentNetherBridgePiece getNextComponent(
      ComponentNetherBridgeStartPiece par1ComponentNetherBridgeStartPiece, List par2List, List par3List, Random par4Random, long par5, int par6, long par7, int par8, int par9
   ) {
      int var10x = this.a(par2List);
      boolean var11x = var10x > 0 && par9 <= 30;
      int var12 = 0;

      while (var12 < 5 && var11x) {
         var12++;
         int var13 = par4Random.nextInt(var10x);

         for (ahk var15 : par2List) {
            var13 -= var15.b;
            if (var13 < 0) {
               if (!var15.a(par9) || var15 == par1ComponentNetherBridgeStartPiece.a && !var15.e) {
                  break;
               }

               ComponentNetherBridgePiece var16 = StructureNetherBridgePieces.createNextComponent(var15, par3List, par4Random, par5, par6, par7, par8, par9);
               if (var16 != null) {
                  var15.c++;
                  par1ComponentNetherBridgeStartPiece.a = var15;
                  if (!var15.a()) {
                     par2List.remove(var15);
                  }

                  return var16;
               }
            }
         }
      }

      return ComponentNetherBridgeEnd.func_40023_a(par3List, par4Random, par5, par6, par7, par8, par9);
   }

   private StructureComponent getNextComponent(
      ComponentNetherBridgeStartPiece par1ComponentNetherBridgeStartPiece, List par2List, Random par3Random, long par4, int par5, long par6, int par7, int par8, boolean par9
   ) {
      if (Math.abs(par4 - par1ComponentNetherBridgeStartPiece.b().a) <= 112L && Math.abs(par6 - par1ComponentNetherBridgeStartPiece.b().c) <= 112L) {
         List list = par1ComponentNetherBridgeStartPiece.b;
         if (par9) {
            list = par1ComponentNetherBridgeStartPiece.c;
         }

         ComponentNetherBridgePiece componentnetherbridgepiece = this.getNextComponent(
            par1ComponentNetherBridgeStartPiece, list, par2List, par3Random, par4, par5, par6, par7, par8 + 1
         );
         if (componentnetherbridgepiece != null) {
            par2List.add(componentnetherbridgepiece);
            par1ComponentNetherBridgeStartPiece.d.add(componentnetherbridgepiece);
         }

         return componentnetherbridgepiece;
      } else {
         return ComponentNetherBridgeEnd.func_40023_a(par2List, par3Random, par4, par5, par6, par7, par8);
      }
   }

   protected StructureComponent a(ComponentNetherBridgeStartPiece par1ComponentNetherBridgeStartPiece, List par2List, Random par3Random, int par4, int par5, boolean par6) {
      switch (this.h) {
         case 0:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par4, this.g.b + par5, this.g.f + 1L, this.h, this.c(), par6
            );
         case 1:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a - 1L, this.g.b + par5, this.g.c + par4, this.h, this.c(), par6
            );
         case 2:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par4, this.g.b + par5, this.g.c - 1L, this.h, this.c(), par6
            );
         case 3:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.d + 1L, this.g.b + par5, this.g.c + par4, this.h, this.c(), par6
            );
         default:
            return null;
      }
   }

   protected StructureComponent b(ComponentNetherBridgeStartPiece par1ComponentNetherBridgeStartPiece, List par2List, Random par3Random, int par4, int par5, boolean par6) {
      switch (this.h) {
         case 0:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c(), par6
            );
         case 1:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c(), par6
            );
         case 2:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a - 1L, this.g.b + par4, this.g.c + par5, 1, this.c(), par6
            );
         case 3:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.c - 1L, 2, this.c(), par6
            );
         default:
            return null;
      }
   }

   protected StructureComponent c(ComponentNetherBridgeStartPiece par1ComponentNetherBridgeStartPiece, List par2List, Random par3Random, int par4, int par5, boolean par6) {
      switch (this.h) {
         case 0:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c(), par6
            );
         case 1:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c(), par6
            );
         case 2:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.d + 1L, this.g.b + par4, this.g.c + par5, 3, this.c(), par6
            );
         case 3:
            return this.getNextComponent(
               par1ComponentNetherBridgeStartPiece, par2List, par3Random, this.g.a + par5, this.g.b + par4, this.g.f + 1L, 0, this.c(), par6
            );
         default:
            return null;
      }
   }

   protected static boolean a(StructureBoundingBox par0StructureBoundingBox) {
      return par0StructureBoundingBox != null && par0StructureBoundingBox.b > 10;
   }
}
